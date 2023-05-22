package com.example.grpc.grpcSimulater2;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.ObjectPool;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.channel.ChannelOption;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.chb.examples.lib.Fit2Grpc;

import java.nio.channels.Channel;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class GrpcCreateStub2 {
    private static GrpcCreateStub2 createStubInstance;
    private Fit2Grpc.Fit2Stub stub;
    private Fit2Grpc.Fit2BlockingStub blockingStub;
    private GenericObjectPool<ManagedChannel> channelPool;

    public Fit2Grpc.Fit2Stub getStub(String host, int port){
        return Optional.ofNullable(stub).orElseGet(()->{
            ManagedChannel channel = NettyChannelBuilder
                    .forAddress(host, port)
                    .keepAliveWithoutCalls(true)
                    //.keepAliveTime(30, TimeUnit.SECONDS)
                    //.keepAliveTimeout(10, TimeUnit.SECONDS)
                    .withOption(ChannelOption.TCP_NODELAY, true)
                    .usePlaintext()
                    .build();
            return stub = Fit2Grpc.newStub(channel);
        });
    }

    public Fit2Grpc.Fit2BlockingStub getBlockingStub(String host, int port) {
        return Optional.ofNullable(blockingStub)
                .orElseGet(()->{
                    ManagedChannel channel = ManagedChannelBuilder
                            .forAddress(host, port)
                            .usePlaintext()
                            .build();
                    return blockingStub = Fit2Grpc.newBlockingStub(channel);
                });
    }
    public static GrpcCreateStub2 getCreateStubInstance(){
        return Optional.ofNullable(createStubInstance)
                .orElseGet(()->createStubInstance = new GrpcCreateStub2());
    }

}
