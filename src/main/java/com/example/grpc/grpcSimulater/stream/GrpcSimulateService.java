package com.example.grpc.grpcSimulater.stream;

import io.grpc.stub.StreamObserver;
import org.chb.examples.lib.FitGrpc;
import org.chb.examples.lib.RequestFit;
import org.chb.examples.lib.ResponseFit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrpcSimulateService {
    String connectHost = "127.0.0.1";
    int connectPort = 9095;
    // Stub => 클라이언트에서 서버로 보낼 때 사용 되는 객체
    final FitGrpc.FitStub stub = GrpcCreateStub.getStubInstance(connectHost,connectPort);

    public void simulateStreamingService() {
        StreamObserver<RequestFit> streamFitReq = this.stub.streamingFitAndSim(new StreamObserver<ResponseFit>() {
            /**
             * 응답부 실행내용 구현
             *
             * @param value the value passed to the stream
             */
            @Override
            public void onNext(ResponseFit value) {
                System.out.println("결함 주입 성공 여부 : " + value.getFitRunResult());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("exit");
            }
        });
        /**
         * 서버로 요청하는 부분
         */
        List<String> list = new ArrayList<>();
        list.add("TC-001");
        list.add("TC-002");
        list.add("TC-003");
        Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(!line.equals("exit")) {
                    list.stream().forEach(v -> {
                        RequestFit.Builder req = RequestFit.newBuilder().setFitTcName(v);
                        streamFitReq.onNext(req.build());
                    });
                }
            }
    }
}
