package com.example.grpc.grpcFit2;

import io.grpc.ManagedChannelBuilder;
import org.chb.examples.lib.Fit2Grpc;

import java.util.Optional;

public class GrpcCreateStub2 {
    private static GrpcCreateStub2 stubInstance;
    private Fit2Grpc.Fit2Stub stub;
    public static GrpcCreateStub2 getCreateStubInstance(){
        return Optional.ofNullable(stubInstance)
                .orElseGet(()->stubInstance = new GrpcCreateStub2());
    }
    private Fit2Grpc.Fit2Stub createStub(String host, int port){
        return stub = Fit2Grpc.newStub(ManagedChannelBuilder.forAddress(host, port)
                .keepAliveWithoutCalls(true)
                .usePlaintext()
                .build());
    }
    public Fit2Grpc.Fit2Stub getStub(String host, int port){
        return Optional.ofNullable(stub)
                .orElseGet(()->stub = createStub(host, port));
    }
}
