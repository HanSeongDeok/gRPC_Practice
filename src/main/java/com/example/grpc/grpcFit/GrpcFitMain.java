package com.example.grpc.grpcFit;

import com.example.grpc.grpcFit.controller.GrpcFitController;
import com.example.grpc.grpcFit.service.GrpcFitService;

import java.io.IOException;
import java.util.List;

public class GrpcFitMain {
    public static void main(String[] args) throws IOException, InterruptedException{
            GrpcFitController controller = new GrpcFitController(9095);
             controller.start();
             controller.blockUntilShutdown();

     /*   List<String> names = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        Map<Integer, String> map = new HashMap();
        numbers.stream().forEach(v -> map.put(v, names.get(v)));

        List<Integer> poll = new ArrayList(map.keySet());

        Collections.shuffle(poll);
        poll.stream().forEach(v -> System.out.println(map.get(v)));*/
    }
}
