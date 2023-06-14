package com.example.grpc.tree;

public class TreeNode {
    private int var;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode() {}
    public TreeNode(int var){
        this.var = var;
    }
    public TreeNode(int var, TreeNode leftNode, TreeNode rightNode) {
        this.var = var;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getVar() {
        return var;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString(){
        return String.valueOf(var);
    }
}
