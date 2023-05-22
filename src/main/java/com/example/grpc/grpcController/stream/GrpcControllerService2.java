package com.example.grpc.grpcController.stream;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcControllerService2 {
    int port;
    Server server;
    public GrpcControllerService2(int port){
        this.port = port;
    }
    public void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new WriteMemoryInfo2())
                .build()
                .start();

        System.out.println("Listening Server : " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Shutting Down Server");
            stop();
        }));
    }

    private void stop(){
        if (server != null) {
            server.shutdown();
        }
    }
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
