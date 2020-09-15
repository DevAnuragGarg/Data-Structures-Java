package com.anudev.ds.trees;

import java.util.Stack;

public class InOrderTraversal {

    public void inOrderTraversal(Node node) {
        System.out.print("Recursive In order traversal: \t\t");
        recursiveInOrderTraversal(node);
        System.out.println();
        System.out.print("Non Recursive In order traversal: \t");
        nonRecursiveInOrderTraversal(node);
        System.out.println();
    }

    private void recursiveInOrderTraversal(Node node) {
        if (node != null) {
            recursiveInOrderTraversal(node.getLeftNode());
            System.out.print(node.getValue() + ",");
            recursiveInOrderTraversal(node.getRightNode());
        }
    }

    private void nonRecursiveInOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();

        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.getLeftNode();
            }
            if (stack.isEmpty()) {
                break;
            }
            node = stack.pop();
            System.out.print(node.getValue() + ",");
            node = node.getRightNode();
        }
    }
}
