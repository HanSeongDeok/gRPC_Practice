package com.example.grpc.grpcFit.stream;

import com.example.grpc.grpcFit.dto.GrpcFitInjectionDTO;
import com.example.grpc.grpcFit.stub.GrpcCreateStubForController;
import io.grpc.StatusRuntimeException;
import org.chb.examples.lib.ControllerGrpc;
import org.chb.examples.lib.RequestController;
import org.chb.examples.lib.RequestFit;

import java.util.Map;
import java.util.Optional;

public class GrpcFitIntoControllerTransfer {
    /**
     * 제어기로 요청하기 위한 stub 객체 선언
     */
    final static String connectHost = "127.0.0.1";
    final static int connectPort = 9096;
    private final static ControllerGrpc.ControllerStub stub = GrpcCreateStubForController.getStubInstance(connectHost, connectPort);
    private static GrpcFitIntoControllerTransfer transferInstance;

    public static GrpcFitIntoControllerTransfer getTransferInstance(){
        return Optional.ofNullable(transferInstance)
                .orElseGet(()->transferInstance = new GrpcFitIntoControllerTransfer());
    }

    /**
     * 제어기 모듈로 전송 메소드
     * @param value
     * @param map
     */
    public void gRPCIntoController(RequestFit value, Map<String, GrpcFitInjectionDTO> map) {
        try {
            GrpcRequestStreamObserver.getRequestObserver(stub)
                    .onNext(getControllerBuilder(value, map));
        } catch (StatusRuntimeException e) {
            System.out.println("이 분기로 갈 수가 없음 왜냐하면 onNext 가 비동기적으로 동작하기 때문");
            System.out.println("따라서 proto 파일에 서버가 연결 되었는지 묻는 메소드도 정의해야함");
        }
    }

    /**
     * Controller Builder -> Request 에 필요한 정의된 메시지 객체
     * @param value
     * @param map
     * @return
     */
    private RequestController getControllerBuilder(RequestFit value, Map<String, GrpcFitInjectionDTO> map) {
        return RequestController.newBuilder()
                .setAddress(map.get(value.getFitTcName()).getAddress())
                .setVar(map.get(value.getFitTcName()).getVar())
                .build();
    }
}
