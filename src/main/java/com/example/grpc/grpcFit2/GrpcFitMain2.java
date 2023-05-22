package com.example.grpc.grpcFit2;

import java.io.IOException;

public class GrpcFitMain2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcFitController2 serverStart = new GrpcFitController2(9099);
        serverStart.start();
        serverStart.blockUntilShutdown();
    }
}
