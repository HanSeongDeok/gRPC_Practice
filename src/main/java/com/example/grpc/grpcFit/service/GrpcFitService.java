package com.example.grpc.grpcFit.service;

import com.example.grpc.grpcFit.dto.GrpcFitInjectionDTO;
import com.example.grpc.grpcFit.stream.GrpcFitIntoControllerTransfer;
import com.example.grpc.grpcFit.repository.GrpcFitRepository;
import com.example.grpc.grpcFit.stream.GrpcRequestStreamObserver;
import io.grpc.*;
import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.*;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
    /**
     * 클라이언트로 응답을 보내기 위한 객체 FitGrpc.FitImplBase
     */
    public class GrpcFitService extends FitGrpc.FitImplBase {
        private static AtomicInteger listSizeIndex = new AtomicInteger();
        @Override
        public StreamObserver<RequestFit> streamingFitAndSim(StreamObserver<ResponseFit> responseObserver) {
            return new StreamObserver<RequestFit>() {
                @Override
                public void onNext(RequestFit value) {
                    Map<String, GrpcFitInjectionDTO> map = GrpcFitRepository.getFaultTcInfo();
                    // 요청 TC-Name 이 존재하지 않을 경우 예외처리 발생.
                    Optional.ofNullable(map.get(value.getFitTcName()))
                            .orElseThrow(NullPointerException::new);

                    // address 와 variable 값 확인
                    System.out.println("address : " + map.get(value.getFitTcName()).getAddress()+
                            "\nvariable : " + map.get(value.getFitTcName()).getVar());

                    // 제어기 모듈로 gRPC Request 전송
                    GrpcFitIntoControllerTransfer.getTransferInstance().gRPCIntoController(value, map);

                    /**
                     * onNext 메소드가 비동기적으로 동작하기 때문에 awiat 하여 동기화 맞춰 줘야함.
                     */
                    try{
                        while(GrpcRequestStreamObserver.getMessages().size()<=listSizeIndex.get()) {
                            /*if (Context.current().getDeadline().isExpired()) {
                                responseObserver.onError(Status.DEADLINE_EXCEEDED
                                        .withDescription("The request took too long to process")
                                        .asRuntimeException());
                            }*/
                        }
                    }catch (Exception e) {
                        responseObserver.onError(e);
                    }

                    // 제어기 모듈에서 응답한 데이터를 로직처리하여 시뮬레이터에게로 응답
                    ResponseFit fitRes = ResponseFit.newBuilder()
                                    .setFitRunResult(GrpcRequestStreamObserver.getMessages().get(listSizeIndex.getAndIncrement()))
                                    .build();

                    responseObserver.onNext(fitRes);
                }
                @Override
                public void onError(Throwable t) {

                }
                @Override
                public void onCompleted() {

                }
            };
        }
    }
