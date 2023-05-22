package com.example.grpc.grpcSimulater2;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.concurrent.TimeUnit;

public class ManagedChannelFactory2 extends BasePooledObjectFactory<ManagedChannel> {
    private final String host;
    private final int port;

    public ManagedChannelFactory2(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public ManagedChannel create() throws Exception {
        return ManagedChannelBuilder
                .forAddress(host,port)
                //.keepAliveTime(20, TimeUnit.SECONDS)
                //.keepAliveTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public PooledObject<ManagedChannel> wrap(ManagedChannel channel) {
        return new DefaultPooledObject<>(channel);
    }
}
