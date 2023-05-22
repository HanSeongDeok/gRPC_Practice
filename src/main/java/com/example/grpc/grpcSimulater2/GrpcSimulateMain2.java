package com.example.grpc.grpcSimulater2;

import java.util.concurrent.ExecutionException;

public class GrpcSimulateMain2 {
    public static void main(String[] args) throws Exception {
        GrpcSimulateService2 clientStart = new GrpcSimulateService2();
        clientStart.faultInjectionRequest();
    }
}
