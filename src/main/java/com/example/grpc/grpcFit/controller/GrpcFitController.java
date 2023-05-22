package com.example.grpc.grpcFit.controller;

import com.example.grpc.grpcFit.service.GrpcFitService;
import io.grpc.BindableService;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcFitController {
    int port;
    Server server;
    public GrpcFitController(int port){
        this.port = port;
    }
    public void start() throws IOException {
        server = ServerBuilder.forPort(this.port)
                .addService(new GrpcFitService())
                .build()
                .start();
        System.out.println("Server Start, Listening on port " + this.port);

        Runtime.getRuntime().addShutdownHook(new Thread(()-> {
            System.out.println("Shutting down gRPC Server");
            stop();
        }));
    }
    public void stop(){
        if(server!=null){ server.shutdown(); }
    }
    public void blockUntilShutdown() throws InterruptedException {
        if(server != null) { server.awaitTermination(); }
    }
}
