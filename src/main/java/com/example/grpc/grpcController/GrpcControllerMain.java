package com.example.grpc.grpcController;

import com.example.grpc.grpcController.stream.GrpcControllerService;
import com.example.grpc.grpcController.stream.GrpcControllerService2;

import java.io.IOException;

public class GrpcControllerMain {
    public static void main(String[] args) throws IOException, InterruptedException {
      /* GrpcControllerService service = new GrpcControllerService(9096);
        service.start();
        service.blockUntilShutdown();*/

        GrpcControllerService2 service2 = new GrpcControllerService2(9094);
        service2.start();
        service2.blockUntilShutdown();

    }
}
