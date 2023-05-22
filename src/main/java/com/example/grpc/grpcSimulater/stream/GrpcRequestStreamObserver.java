package com.example.grpc.grpcSimulater.stream;

import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.FitGrpc;
import org.chb.examples.lib.RequestFit;
import org.chb.examples.lib.ResponseFit;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class GrpcRequestStreamObserver {
    private final static GrpcRequestStreamObserver observerInstance = new GrpcRequestStreamObserver();
    private StreamObserver<RequestFit> observer;
    private StreamObserver<RequestFit> createStreamObserver(FitGrpc.FitStub stub){
        return observer = stub.streamingFitAndSim(new StreamObserver<ResponseFit>() {
            /**
             * 응답부 실행내용 구현
             * @param value the value passed to the stream
             */
            @Override
            public void onNext(ResponseFit value) {
                System.out.println("Fault Injection Successful or Not : " + value.getFitRunResult());
            }
            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }
            @Override
            public void onCompleted() {
                System.out.println("exit-Simulate");
            }
        });
    }
/*    private static FitGrpc.FitStub deadlineStubResponse(FitGrpc.FitStub stub) {
        return stub.withDeadlineAfter(11, TimeUnit.SECONDS);
    }*/

    public static StreamObserver<RequestFit> getRequestObserver(FitGrpc.FitStub stub){
        return Optional.ofNullable(observerInstance.observer)
                .orElseGet(()-> observerInstance.createStreamObserver(stub));
    }

/*    public static void resetStubDeadLine(){
        observerInstance.observer = null;
    }*/
}
