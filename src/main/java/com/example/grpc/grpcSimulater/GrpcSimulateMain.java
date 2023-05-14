package com.example.grpc.grpcSimulater;

import com.example.grpc.grpcSimulater.stream.GrpcSimulateService;

public class GrpcSimulateMain {
    public static void main(String[] args) {
        GrpcSimulateService service = new GrpcSimulateService();
        service.simulateStreamingService();
    }
}
