package com.example.grpc.grpcFit.stream;

import io.grpc.Grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    private final static List<String> messages = new ArrayList();
    private static AtomicInteger listSizeIndex = new AtomicInteger();
    final static String connectHost = "127.0.0.1";
    final static int connectPort = 9091;

    /**
     * 제어기로 요청하기 위한 stub 객체 선언
     */
    private static ControllerGrpc.ControllerStub stub = GrpcCreateStubForController.getStubInstance(connectHost, connectPort);
    /**
     * 시뮬레이터에서 받은 요청 받은 TC를 분석하여 추출한 메모리 주소값과 변수 값을 제어기 모듈로 보낼 로직 구현
     */
    private static StreamObserver<RequestController> streamControllerReq = stub.streamingFitAndController(new StreamObserver<ResponseController>() {
        @Override
        public void onNext(ResponseController value) {
            System.out.println(value.getMessage());
            messages.add(value.getMessage());
        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onCompleted() {

        }
    });

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
                    System.out.println("address : " + map.get(value.getFitTcName()).getAddress()+
                            "\nvariable : " + map.get(value.getFitTcName()).getVar());

                    RequestController controllerBuilder = RequestController.newBuilder()
                            .setAddress(map.get(value.getFitTcName()).getAddress())
                            .setVar(map.get(value.getFitTcName()).getVar())
                            .build();

                    streamControllerReq.onNext(controllerBuilder);
                    while(messages.size() <= listSizeIndex.get()){
                        //wait
                    }
                    ResponseFit fitRes = ResponseFit.newBuilder()
                                    .setFitRunResult(messages.get(listSizeIndex.getAndIncrement()))
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
