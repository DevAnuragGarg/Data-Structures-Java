package com.anudev.ds.trees;

import java.util.Stack;

public class PreOrderTraversal {

    public void preOrderTraversal(Node node) {
        System.out.print("Recursive Pre order traversal: \t\t");
        recursivePreOrderTraversal(node);
        System.out.println();
        System.out.print("Non Recursive Pre order traversal: \t");
        nonRecursivePreOrderTraversal(node);
        System.out.println();
        System.out.print("Non Recursive Pre order traversal2: ");
        nonRecursivePreOrderTraversal2(node);
        System.out.println();
    }

    private void recursivePreOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + ",");
            recursivePreOrderTraversal(node.getLeftNode());
            recursivePreOrderTraversal(node.getRightNode());
        }
    }

    private void nonRecursivePreOrderTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node stackNode = stack.pop();
            System.out.print(stackNode.getValue() + ",");

            // add the right node first which will be processed later
            if (stackNode.getRightNode() != null) {
                stack.push(stackNode.getRightNode());
            }

            // add the left node which will be popped later
            if (stackNode.getLeftNode() != null) {
                stack.push(stackNode.getLeftNode());
            }
        }
    }

    private void nonRecursivePreOrderTraversal2(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();

        while (true) {
            // keep pushing the left nodes
            while (node != null) {
                System.out.print(node.getValue() + ",");
                stack.push(node);
                node = node.getLeftNode();
            }
            if(stack.isEmpty()){
                break;
            }
            node = stack.pop().getRightNode();
        }
    }
}
