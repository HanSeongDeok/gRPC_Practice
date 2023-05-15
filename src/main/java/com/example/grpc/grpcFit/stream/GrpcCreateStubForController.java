package com.example.grpc.grpcFit.stream;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.chb.examples.lib.ControllerGrpc;
import org.springframework.stereotype.Controller;

import java.util.Optional;

public class GrpcCreateStubForController {
    private ManagedChannel channel;
    private ControllerGrpc.ControllerStub stub;
    private ControllerGrpc.ControllerBlockingStub blockingStub;
    private static GrpcCreateStubForController stubInstance = new GrpcCreateStubForController();
    private ControllerGrpc.ControllerStub createStubForController(String host, int port){
           channel = ManagedChannelBuilder.forAddress(host, port)
                   .usePlaintext()
                   .build();
           stub = ControllerGrpc.newStub(channel);
           return stub;
    }

    private ControllerGrpc.ControllerBlockingStub createBlockingStubForController(String host, int port){
        channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = ControllerGrpc.newBlockingStub(channel);
        return blockingStub;
    }

    public static ControllerGrpc.ControllerStub getStubInstance (String host, int port){
        return Optional.ofNullable(stubInstance.stub).orElseGet(()->stubInstance.createStubForController(host, port));
    }

    public static ControllerGrpc.ControllerBlockingStub getBlockingStubInstance (String host, int port) {
        return Optional.ofNullable(stubInstance.blockingStub).orElseGet(()->stubInstance.createBlockingStubForController(host, port));
    }
}
