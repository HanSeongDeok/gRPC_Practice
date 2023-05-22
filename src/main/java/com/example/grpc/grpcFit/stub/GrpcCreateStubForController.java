package com.example.grpc.grpcFit.stub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.chb.examples.lib.ControllerGrpc;

import java.util.Optional;

public class GrpcCreateStubForController {
    private ManagedChannel channel;
    private ControllerGrpc.ControllerStub stub;
    private final static GrpcCreateStubForController controllerInstance = new GrpcCreateStubForController();
    private ControllerGrpc.ControllerStub createControllerStub(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        stub = ControllerGrpc.newStub(channel);
        return stub;
    }

    public static ControllerGrpc.ControllerStub getStubInstance(String host, int port){
        return Optional.ofNullable(controllerInstance.stub)
                .orElseGet(()->controllerInstance.createControllerStub(host, port));
    }
}
