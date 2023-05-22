package com.example.grpc.grpcFit2;

import com.google.protobuf.ByteString;

public class GrpcFitMemoryInfoDto2 {
    private int address;
    private ByteString byteVar;

    public GrpcFitMemoryInfoDto2(int address, ByteString byteVar){
        this.address = address;
        this.byteVar = byteVar;
    }
    public int getAddress() {
        return address;
    }
    public void setAddress(int address) {
        this.address = address;
    }
    public ByteString getByteVar() {
        return byteVar;
    }
    public void setByteVar(ByteString byteVar) {
        this.byteVar = byteVar;
    }
}
