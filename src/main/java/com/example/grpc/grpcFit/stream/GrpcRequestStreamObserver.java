package com.example.grpc.grpcFit.stream;

import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.ControllerGrpc;
import org.chb.examples.lib.RequestController;
import org.chb.examples.lib.ResponseController;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class GrpcRequestStreamObserver {
    private final static GrpcRequestStreamObserver observerInstance = new GrpcRequestStreamObserver();
    private StreamObserver<RequestController> observer;
    private List<String> messages = new ArrayList();

    private StreamObserver<RequestController> createObserver(ControllerGrpc.ControllerStub stub){
        return  observer = stub.streamingFitAndController(new StreamObserver<ResponseController>() {
            /**
             * 시뮬레이터에서 받은 요청 받은 TC를 분석하여 추출한 메모리 주소값과 변수 값을 제어기 모듈로 보낼 로직 구현
             */
            @Override
            public void onNext(ResponseController value) {
                System.out.println(value.getMessage());
                messages.add(value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("exit-FIT");
            }
        });
    }
    public static List<String> getMessages(){
        return observerInstance.messages;
    }

    public static StreamObserver<RequestController> getRequestObserver(ControllerGrpc.ControllerStub stub) {
        return Optional.ofNullable(observerInstance.observer)
                .orElseGet(()-> observerInstance.createObserver(stub));
    }
}
