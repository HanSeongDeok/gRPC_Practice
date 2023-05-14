package com.example.grpc.grpcFit.stream;

public class GrpcFitInjectionDTO {
    private String address;
    private long var;

    public GrpcFitInjectionDTO(String address, long var){
        this.address = address;
        this.var = var;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getVar() {
        return var;
    }

    public void setVar(long var) {
        this.var = var;
    }
}
