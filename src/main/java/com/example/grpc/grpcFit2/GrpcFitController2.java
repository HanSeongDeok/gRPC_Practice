package com.example.grpc.grpcFit2;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;


public class GrpcFitController2 {
    int port;
    Server server;

    public GrpcFitController2(int port) {
        this.port = port;
    }
    public void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new GrpcFitService2())
                .build();

        server.start();

        System.out.println("Server Listening port: " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Shutting Down gRPC Server");
            stop();
        }));
    }
    private void stop(){
        if(server != null) {
            server.shutdown();
        }
    }
    public void blockUntilShutdown() throws InterruptedException {
        if(server != null) {
            server.awaitTermination();
        }
    }
}
