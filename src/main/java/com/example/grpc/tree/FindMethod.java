package com.example.grpc.tree;

import java.util.List;

public interface FindMethod {
    List<Integer> findInOrder();
    List<Integer> findPreOrder();
    List<Integer> findPostOrder();
}
