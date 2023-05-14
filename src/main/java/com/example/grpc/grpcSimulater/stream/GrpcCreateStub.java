package com.example.grpc.grpcSimulater.stream;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.chb.examples.lib.FitGrpc;

import java.util.Optional;

public class GrpcCreateStub {
    private ManagedChannel channel;
    private FitGrpc.FitStub stub;
    private static GrpcCreateStub stubInstance = new GrpcCreateStub();

    private FitGrpc.FitStub createStub(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        stub = FitGrpc.newStub(channel);
        return stub;
    }

    public static FitGrpc.FitStub getStubInstance(String host, int port) {
        return Optional.ofNullable(stubInstance.stub).orElseGet(()->
                stubInstance.createStub(host, port));
    }
}
