package com.anudev.ds.trees;

public class PreOrderTraversal {

    public void recursivePreOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + ",");
            recursivePreOrderTraversal(node.getLeftNode());
            recursivePreOrderTraversal(node.getRightNode());
        }
    }
}
