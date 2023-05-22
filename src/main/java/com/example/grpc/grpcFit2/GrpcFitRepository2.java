package com.example.grpc.grpcFit2;

import com.google.protobuf.ByteString;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GrpcFitRepository2 {
   private static Map<String, GrpcFitMemoryInfoDto2> map;
   private static GrpcFitRepository2 repositoryInstance;
   public static GrpcFitRepository2 getRepositoryInstance(){
       return Optional.ofNullable(repositoryInstance)
               .orElseGet(()->repositoryInstance = new GrpcFitRepository2());
   }
   public Map<String, GrpcFitMemoryInfoDto2> getRepositoryMap() {
        return Optional.ofNullable(map)
                .orElseGet(()->repositoryInstance.createMap());
   }
   private Map<String, GrpcFitMemoryInfoDto2> createMap(){
       map = new HashMap();
       map.put("TC-001", new GrpcFitMemoryInfoDto2(1, ByteString.copyFromUtf8("var1")));
       map.put("TC-002", new GrpcFitMemoryInfoDto2(2, ByteString.copyFromUtf8("var2")));
       map.put("TC-003", new GrpcFitMemoryInfoDto2(3, ByteString.copyFromUtf8("var3")));
       map.put("TC-004", new GrpcFitMemoryInfoDto2(4, ByteString.copyFromUtf8("var4")));
       map.put("TC-005", new GrpcFitMemoryInfoDto2(5, ByteString.copyFromUtf8("var5")));
       map.put("TC-006", new GrpcFitMemoryInfoDto2(6, ByteString.copyFromUtf8("var6")));
       map.put("TC-007", new GrpcFitMemoryInfoDto2(7, ByteString.copyFromUtf8("var7")));
       map.put("TC-008", new GrpcFitMemoryInfoDto2(8, ByteString.copyFromUtf8("var8")));
       map.put("TC-009", new GrpcFitMemoryInfoDto2(9, ByteString.copyFromUtf8("var9")));
       map.put("TC-010", new GrpcFitMemoryInfoDto2(10, ByteString.copyFromUtf8("var10")));
       return map;
   }
}
