package com.example.grpc.grpcSimulater2;

import com.google.protobuf.Empty;
import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.internal.KeepAliveManager;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.Fit2Grpc;
import org.chb.examples.lib.TcIndex;
import org.chb.examples.lib.TcWriteInfo;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

public class GrpcSimulateService2 {
    String host = "127.0.0.1";
    int port = 9099;
    private Fit2Grpc.Fit2Stub stub = GrpcCreateStub2.getCreateStubInstance().getStub(host, 9099);
    private static List<TcIndex> lists;

    CompletableFuture<Void> writeFuture = new CompletableFuture<>();
    CompletableFuture<Void> checkFuture = new CompletableFuture<>();

    public GrpcSimulateService2() throws Exception {}

    /**
     * 연결상태 check 비동기 작업
     */
    private CompletableFuture<Void> getCheckFuture(){
        return checkFuture = CompletableFuture.runAsync(()->{
            long timeStart = System.currentTimeMillis();
            stub.checkConnection(Empty.newBuilder().build(), new StreamObserver<Empty>() {
                @Override
                public void onNext(Empty value) {
                    System.out.println("Check Connection OK");
                }
                @Override
                public void onError(Throwable t) {
                    System.out.println("TIMEOUT");
                }
                @Override
                public void onCompleted() {
                    System.out.println("GOOD TEST");
                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(System.currentTimeMillis() - timeStart + " : " + Thread.currentThread().getName());
        });
    }

    /**
     * 메모리 write 비동기 작업
     * @param tcIndex
     * @return
     */
    private CompletableFuture<Void> getWriteFuture(TcIndex tcIndex){
        return writeFuture = CompletableFuture.runAsync(()->{
            stub.withDeadlineAfter(20,TimeUnit.SECONDS).writeMemoryInfo(tcIndex, new StreamObserver<TcWriteInfo>() {
                @Override
                public void onNext(TcWriteInfo value) {
                    System.out.println("Address Check : " + value.getAddress() + " Byte Check : " + value.getBytes() + "ACK : " + value.getMessage());
                }
                @Override
                public void onError(Throwable t) {
                    //System.out.println("TIMEOUT");
                    throw new RuntimeException("Connection End", t);
                }
                @Override
                public void onCompleted() {
                    System.out.println("GOOD TEST");
                }
            });
        });
    }

    public void faultInjectionRequest() throws InterruptedException, ExecutionException {
        /**
         * 하나씩 보낸다는 가정
         */
        TcIndex tcIndex = TcIndex.newBuilder()
                .setTcIndex("TC-001")
                .build();
        TcIndex tcIndex2 = TcIndex.newBuilder()
                .setTcIndex("TC-002")
                .build();
        TcIndex tcIndex3 = TcIndex.newBuilder()
                .setTcIndex("TC-003")
                .build();

        /**
         * 한번에 보낸다는 가정
         */
        TcIndex tcIndexTEST = TcIndex.newBuilder()
                .setTcIndex("TC-001")
                .setTcIndex("TC-002")
                .setTcIndex("TC-003")
                .setTcIndex("TC-003")
                .setTcIndex("TC-003")
                .build();

        /**
         * 서버로 송신
         */
        getTcIndex().stream().forEach(tc ->{
            checkFuture = getCheckFuture().thenRun(() -> {
                    getWriteFuture(tc);
            });
        });

        /**
         * 비동기 송신에 의해
         */
        // 두 개의 함수를 모두 호출할 때 까지 기다림
        CompletableFuture<Void> combinedFuture3 = CompletableFuture.allOf(writeFuture,checkFuture);
        combinedFuture3.get();
    }

    /**
     * 하나씩 보낸다는 가정하의 TC list
     * @return
     */
    private static List<TcIndex> getTcIndex() {
        return Optional.ofNullable(lists).orElseGet(()->{
                    TcIndex tcIndex = TcIndex.newBuilder()
                            .setTcIndex("TC-001")
                            .build();
                    TcIndex tcIndex2 = TcIndex.newBuilder()
                            .setTcIndex("TC-002")
                            .build();
                    TcIndex tcIndex3 = TcIndex.newBuilder()
                            .setTcIndex("TC-003")
                            .build();
                     TcIndex tcIndex4 = TcIndex.newBuilder()
                            .setTcIndex("TC-004")
                            .build();
                    TcIndex tcIndex5 = TcIndex.newBuilder()
                            .setTcIndex("TC-005")
                            .build();
                    TcIndex tcIndex6 = TcIndex.newBuilder()
                            .setTcIndex("TC-006")
                            .build();
                    TcIndex tcIndex7 = TcIndex.newBuilder()
                            .setTcIndex("TC-007")
                            .build();
                    TcIndex tcIndex8 = TcIndex.newBuilder()
                            .setTcIndex("TC-008")
                            .build();
                    TcIndex tcIndex9 = TcIndex.newBuilder()
                            .setTcIndex("TC-009")
                            .build();
                    TcIndex tcIndex10 = TcIndex.newBuilder()
                            .setTcIndex("TC-010")
                            .build();

                    lists = new ArrayList<>();
                    lists.add(tcIndex);
                    lists.add(tcIndex2);
                    lists.add(tcIndex3);
                    lists.add(tcIndex4);
                    lists.add(tcIndex5);
                    lists.add(tcIndex6);
                    lists.add(tcIndex7);
                    lists.add(tcIndex8);
                    lists.add(tcIndex9);
                    lists.add(tcIndex10);
                    return lists;
                });
    }
}
