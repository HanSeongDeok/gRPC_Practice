package com.example.grpc.grpcFit.stream;

import io.grpc.*;
import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class GrpcFitService {
    private int port;
    private Server server;
    public GrpcFitService(int port) {
        this.port = port;
    }
    public void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new FitService())
                .build()
                .start();
        System.out.println("Server started, listening on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server");
            stop();
        }));
    }
    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private static AtomicInteger listSizeIndex = new AtomicInteger();

    /**
     * 클라이언트로 응답을 보내기 위한 객체 FitGrpc.FitImplBase
     */
    public class FitService extends FitGrpc.FitImplBase {
        @Override
        public StreamObserver<RequestFit> streamingFitAndSim(StreamObserver<ResponseFit> responseObserver) {
            return new StreamObserver<RequestFit>() {
                @Override
                public void onNext(RequestFit value) {
                    Map<String, GrpcFitInjectionDTO> map = GrpcFitRepository.getFaultTcInfo();

                    // 요청 TC-Name이 존재하지 않을 경우 예외처리 발생.
                    Optional.ofNullable(map.get(value.getFitTcName()))
                            .orElseThrow(NullPointerException::new);

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
}
