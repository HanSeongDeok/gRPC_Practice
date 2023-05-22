package com.example.grpc.grpcFit2;

import com.google.protobuf.Empty;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.internal.GrpcUtil;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.Fit2Grpc;
import org.chb.examples.lib.TcIndex;
import org.chb.examples.lib.TcWriteInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;

public class GrpcFitService2 extends Fit2Grpc.Fit2ImplBase {
    private AtomicLong indexSize = new AtomicLong();
    @Override
    public void checkConnection(Empty request, StreamObserver<Empty> responseObserver) {
        if(request!=null) {
            System.out.println("Check Connection OK");
        }
        responseObserver.onNext(Empty.newBuilder().build());
    }
    @Override
    public void writeMemoryInfo(TcIndex request, StreamObserver<TcWriteInfo> responseObserver) {

     /*   Context currentContext = Context.current();
        Deadline deadline = currentContext.getDeadline();
        if(deadline != null && !deadline.isExpired()){
            System.out.println("TEST : " + deadline.toString());
        }*/

        Map<String, GrpcFitMemoryInfoDto2> map = GrpcFitRepository2.getRepositoryInstance().getRepositoryMap();

        AtomicReference<TcWriteInfo> info = new AtomicReference<>();
        info.getAndSet(TcWriteInfo.newBuilder()
                .setAddress(Optional.ofNullable(map.get(request.getTcIndex()).getAddress())
                        .orElseThrow(()->new NullPointerException("TC 존재 안함")))
                .setBytes(Optional.ofNullable(map.get(request.getTcIndex()).getByteVar())
                        .orElseThrow(()->new NullPointerException("TC 존재 안함")))
                .build());

        indexSize.incrementAndGet();
        System.out.println("index size : " + indexSize);

        GrpcFitToDebugger2.getGrpcFitToDebugger().fitToDebugger(info.get());
        while ((int)indexSize.get() != GrpcFitToDebugger2.getGrpcFitToDebugger().getList().size()){
        }

        responseObserver.onNext(GrpcFitToDebugger2.getGrpcFitToDebugger().getList().get((int) indexSize.decrementAndGet()));
        responseObserver.onCompleted();
        GrpcFitToDebugger2.getGrpcFitToDebugger().getList().clear();
        indexSize.set(0);
    }
}
