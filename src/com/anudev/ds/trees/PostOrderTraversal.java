package com.anudev.ds.trees;

public class PostOrderTraversal {

    public void postOrderTraversal(Node node) {
        System.out.print("Recursive Post order traversal: ");
        recursivePostOrderTraversal(node);
        System.out.println();
    }

    private void recursivePostOrderTraversal(Node node) {
        if (node != null) {
            recursivePostOrderTraversal(node.getLeftNode());
            recursivePostOrderTraversal(node.getRightNode());
            System.out.print(node.getValue() + ",");
        }
    }
}
