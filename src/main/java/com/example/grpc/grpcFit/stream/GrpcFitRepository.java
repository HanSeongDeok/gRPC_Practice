package com.example.grpc.grpcFit.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GrpcFitRepository {
    private static Map<String, GrpcFitInjectionDTO> faultTcInfo;

    private static GrpcFitRepository repositoryInstance= new GrpcFitRepository();

    public GrpcFitRepository(){
        //createFaultTcInfo();
    }

    public static Map<String, GrpcFitInjectionDTO> getFaultTcInfo(){
        return Optional.ofNullable(faultTcInfo)
                .orElseGet(()->repositoryInstance.createFaultTcInfo());
            }

    private Map<String, GrpcFitInjectionDTO> createFaultTcInfo(){
        faultTcInfo = new HashMap();
        faultTcInfo.put("TC-001", new GrpcFitInjectionDTO("0x21457",1000));
        faultTcInfo.put("TC-002", new GrpcFitInjectionDTO("0x53626",2000));
        faultTcInfo.put("TC-003", new GrpcFitInjectionDTO("0x34235",3000));
        return faultTcInfo;
    }
}
