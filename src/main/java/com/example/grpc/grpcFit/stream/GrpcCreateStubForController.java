package com.example.grpc.grpcFit.stream;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.chb.examples.lib.ControllerGrpc;
import org.springframework.stereotype.Controller;

import java.util.Optional;

public class GrpcCreateStubForController {
    private ManagedChannel channel;
    private ControllerGrpc.ControllerStub stub;
    private static GrpcCreateStubForController stubInstance = new GrpcCreateStubForController();
    private ControllerGrpc.ControllerStub createStubForController(String host, int port){
           channel = ManagedChannelBuilder.forAddress(host, port)
                   .usePlaintext()
                   .build();
           stub = ControllerGrpc.newStub(channel);
           return stub;
    }

    public static ControllerGrpc.ControllerStub getStubInstance (String host, int port){
        return Optional.ofNullable(stubInstance.stub).orElseGet(()->stubInstance.createStubForController(host, port));
    }
}
