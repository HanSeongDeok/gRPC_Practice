package com.example.grpc.grpcFit2;

import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.Fit2Grpc;
import org.chb.examples.lib.TcWriteInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class GrpcFitToDebugger2 {
    String host = "127.0.0.1";
    int port = 9094;
    private static GrpcFitToDebugger2 debugger;
    private static List<TcWriteInfo> list;

    final private Fit2Grpc.Fit2Stub stub = GrpcCreateStub2.getCreateStubInstance().getStub(host,port);

    /**
     * 동기적으로 클라이언트에서 온 요청을 동기적으로 디버거 서버로 전달해줌
     * @param info
     */
    public void fitToDebugger(TcWriteInfo info){
        stub.withDeadlineAfter(20, TimeUnit.SECONDS).writeMemory(info, new StreamObserver<TcWriteInfo>() {
            @Override
            public void onNext(TcWriteInfo value) {
                System.out.println(value.getMessage());
                list.add(value);
            }
            @Override
            public void onError(Throwable t) {
                throw new RuntimeException("Connection End", t);
            }
            @Override
            public void onCompleted() {
                System.out.println("GOOD");
            }
        });
    }

    /**
     * 비동기적으로 클라이언트에서 온 요청을 비동기적으로 디버거 서버로 전달해줌
     * @return
     */
    public CompletableFuture<Void> fitToDebugger2(TcWriteInfo info){
        return CompletableFuture.runAsync(()->{
            stub.withDeadlineAfter(20, TimeUnit.SECONDS).writeMemory(info, new StreamObserver<TcWriteInfo>() {
                @Override
                public void onNext(TcWriteInfo value) {
                    System.out.println(value.getMessage());
                    list.add(value);
                }
                @Override
                public void onError(Throwable t) {
                    throw new RuntimeException("Connection End", t);
                }
                @Override
                public void onCompleted() {
                    System.out.println("GOOD");
                }
            });
        });
    }


    public List<TcWriteInfo> getList(){
        return Optional.ofNullable(list)
                .orElseGet(()-> list = new ArrayList<>());
    }
    public static GrpcFitToDebugger2 getGrpcFitToDebugger(){
        return Optional.ofNullable(debugger)
                .orElseGet(()->debugger = new GrpcFitToDebugger2());
    }
}
