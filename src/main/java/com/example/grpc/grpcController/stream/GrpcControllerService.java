package com.example.grpc.grpcController.stream;

import com.google.protobuf.Empty;
import io.grpc.*;
import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.ControllerGrpc;
import org.chb.examples.lib.RequestController;
import org.chb.examples.lib.ResponseController;
import org.springframework.stereotype.Controller;

import java.io.IOException;

public class GrpcControllerService {
    private int port;
    private Server server;
    public GrpcControllerService(int port) {
        this.port = port;
    }
    public void start() throws IOException{
        server = ServerBuilder.forPort(port)
                .addService(new ControllerService())
                .build()
                .start();

        System.out.println("Server started, listening on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() ->{
            System.out.println("Shutting down gRPC server");
            stop();
        }));
    }

    public void stop(){
        if(server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if(server != null) {
            server.awaitTermination();
        }
    }

    private static class ControllerService extends ControllerGrpc.ControllerImplBase {
        @Override
        public StreamObserver<RequestController> streamingFitAndController(StreamObserver<ResponseController> responseObserver) {
            return new StreamObserver<RequestController>(){
                @Override
                public void onNext(RequestController value) {
                    System.out.println(value.getAddress());
                    System.out.println(value.getVar());

                    ResponseController responseController = ResponseController.newBuilder()
                                            .setMessage("Successful : 200")
                                            .build();
                    responseObserver.onNext(responseController);

                }
                @Override
                public void onError(Throwable t) {}
                @Override
                public void onCompleted() {}
            };
        }

        @Override
        public StreamObserver<Empty> checkConnection(StreamObserver<Empty> responseObserver) {
            return new StreamObserver<Empty>() {
                @Override
                public void onNext(Empty value) {
                    System.out.println("good");
                    responseObserver.onNext(Empty.newBuilder().build());
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
