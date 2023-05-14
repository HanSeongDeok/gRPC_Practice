package com.example.grpc.grpcFit.stream;

import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.ControllerGrpc;
import org.chb.examples.lib.RequestController;
import org.chb.examples.lib.ResponseController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GrpcFitTowardController {
    final static List<String> messages = new ArrayList();
    static AtomicInteger listSizeIndex = new AtomicInteger();
    static String connectHost = "127.0.0.1";
    static int connectPort = 9091;

    /**
     * 제어기로 요청하기 위한 stub 객체 선언
     */
    public static ControllerGrpc.ControllerStub stub = GrpcCreateStubForController.getStubInstance(connectHost, connectPort);
    /**
     * 시뮬레이터에서 받은 요청 받은 TC를 분석하여 추출한 메모리 주소값과 변수 값을 제어기 모듈로 보낼 로직 구현
     */
    public static StreamObserver<RequestController> streamControllerReq = stub.streamingFitAndController(new StreamObserver<ResponseController>() {
        @Override
        public void onNext(ResponseController value) {
            System.out.println(value.getMessage());
            messages.add(value.getMessage());
        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onCompleted() {

        }
    });

}
