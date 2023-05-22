package com.example.grpc.grpcController.stream;

import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.Fit2Grpc;
import org.chb.examples.lib.TcIndex;
import org.chb.examples.lib.TcWriteInfo;

public class WriteMemoryInfo2 extends Fit2Grpc.Fit2ImplBase {
    @Override
    public void writeMemory(TcWriteInfo request, StreamObserver<TcWriteInfo> responseObserver) {
        System.out.println(request.getAddress() + " : " + request.getBytes());
        TcWriteInfo info = TcWriteInfo.newBuilder()
                .setAddress(request.getAddress())
                .setBytes(request.getBytes())
                .setMessage("Ack : 200")
                .build();
        responseObserver.onNext(info);
        responseObserver.onCompleted();
    }
}
