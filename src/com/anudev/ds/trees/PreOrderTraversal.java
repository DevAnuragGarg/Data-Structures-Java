package com.anudev.ds.trees;

public class PreOrderTraversal {

    public void preOrderTraversal(Node node) {
        System.out.print("Pre order traversal: ");
        recursivePreOrderTraversal(node);
        System.out.println();
    }

    private void recursivePreOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + ",");
            recursivePreOrderTraversal(node.getLeftNode());
            recursivePreOrderTraversal(node.getRightNode());
        }
    }
}
