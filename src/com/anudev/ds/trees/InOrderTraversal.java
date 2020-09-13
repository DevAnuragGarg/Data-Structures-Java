package com.anudev.ds.trees;

public class InOrderTraversal {

    public void inOrderTraversal(Node node) {
        System.out.print("In order traversal: ");
        recursiveInOrderTraversal(node);
        System.out.println();
    }

    private void recursiveInOrderTraversal(Node node) {
        if (node != null) {
            recursiveInOrderTraversal(node.getLeftNode());
            System.out.print(node.getValue() + ",");
            recursiveInOrderTraversal(node.getRightNode());
        }
    }
}
