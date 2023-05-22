package com.example.grpc.grpcFit2;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.netty.shaded.io.netty.channel.ChannelOption;
import io.grpc.netty.shaded.io.netty.channel.nio.NioEventLoopGroup;
import io.grpc.netty.shaded.io.netty.channel.socket.nio.NioServerSocketChannel;
import io.grpc.netty.shaded.io.netty.handler.codec.http2.Http2ConnectionHandler;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GrpcFitController2 {
    int port;
    Server server;
    //ManagedChannel serverBuilder;
    NettyServerBuilder serverBuilder;
    public GrpcFitController2(int port) {
        this.port = port;
    }
    public void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new GrpcFitService2())
                .build();

        /*NettyServerBuilder serverBuilder2 = NettyServerBuilder.forPort(port)
                .channelType(NioServerSocketChannel.class)
                .bossEventLoopGroup(new NioEventLoopGroup())
                .workerEventLoopGroup(new NioEventLoopGroup())
                .executor(Executors.newFixedThreadPool(100))
                .maxConcurrentCallsPerConnection(100)
                .maxConnectionAge(1,TimeUnit.HOURS)
                .maxConnectionAgeGrace(5,TimeUnit.HOURS)
                .addService(new GrpcFitService2());
*/
        //server = serverBuilder2.build();
        server.start();

        System.out.println("Server Listening port: " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Shutting Down gRPC Server");
            stop();
        }));
    }
    private void stop(){
        if(server != null) {
            server.shutdown();
        }
    }
    public void blockUntilShutdown() throws InterruptedException {
        if(server != null) {
            server.awaitTermination();
        }
    }
}
