package com.example.grpc.grpcController;

import com.example.grpc.grpcController.stream.GrpcControllerService;

import java.io.IOException;

public class GrpcControllerMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcControllerService service = new GrpcControllerService(9092);
        service.start();
        service.blockUntilShutdown();
    }
}
