package com.example.grpc.grpcFit;

import com.example.grpc.grpcFit.stream.GrpcFitService;
import com.example.grpc.grpcFit.stream.GrpcFitTowardController;

import java.io.IOException;
import java.util.Optional;

public class GrpcFitMain {
    public static void main(String[] args) throws IOException, InterruptedException{
            GrpcFitService service = new GrpcFitService(9095);
            service.start();
            service.blockUntilShutdown();
    }
}
