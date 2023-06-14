package com.example.grpc.tree;

import java.util.ArrayList;
import java.util.List;

public class FindTreeNode implements FindMethod{
    private final TreeNode treeNode;
    private List<Integer> list = new ArrayList<>();
    public FindTreeNode(TreeNode treeNode){
        this.treeNode = treeNode;
    }
    @Override
    public List<Integer> findInOrder() {
        return findNode(treeNode);
    }
    private List<Integer> findNode(TreeNode treeNode){
        if (treeNode == null) {
            return null;
        }
        findNode(treeNode.getLeftNode());
        list.add(treeNode.getVar());
        findNode(treeNode.getRightNode());
        return list;
    }
    @Override
    public List<Integer> findPreOrder() {
        return null;
    }
    @Override
    public List<Integer> findPostOrder() {
        return null;
    }
    public static void main(String[] args) {

    }
}
