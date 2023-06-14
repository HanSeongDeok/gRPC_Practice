package com.example.grpc.tree;

import java.util.Optional;

public class CreateTreeNode {
    int[] treeNodeValue;
    final int START_INDEX = 0;
    public CreateTreeNode(int[] treeNodeValue) {
        this.treeNodeValue = treeNodeValue;
    }
    public TreeNode createTree(){
        return addValue(START_INDEX);
    }
    private TreeNode addValue(int index){
        if (index >= treeNodeValue.length || treeNodeValue[index] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(treeNodeValue[index]);
        root.setLeftNode(addValue(2 * index + 1));
        root.setRightNode(addValue(2 * index + 2));

        return root;
    }
    public static void main(String[] args) {
        int [] treeValue = {3, 1, 4, 3, -1, 1, 5};
        CreateTreeNode createTreeNode = new CreateTreeNode(treeValue);
        TreeNode root = createTreeNode.createTree();


        Optional.ofNullable(createTreeNode.createTree())
                .ifPresent(treeNode -> {

                });
    }
}
