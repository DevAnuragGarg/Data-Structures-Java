package com.anudev.ds.trees;

import java.util.Stack;

/**
 * In pre-order and in-order after popping we do no need to visit the
 * same vertex again. But in post-order we need to process is node twice.
 * After processing the left subtree we will visit the current node and
 * after processing the right subtree we visit the current node. But we
 * need to process the current node during second visit.
 */
public class PostOrderTraversal {

    public static void postOrderTraversal(Node node) {
        System.out.print("Recursive Post order traversal: \t");
        recursivePostOrderTraversal(node);
        System.out.println();
        System.out.print("Non Recursive Post order traversal: ");
        nonRecursivePostOrderTraversal(node);
        System.out.println();
    }

    private static void recursivePostOrderTraversal(Node node) {
        if (node != null) {
            recursivePostOrderTraversal(node.getLeftNode());
            recursivePostOrderTraversal(node.getRightNode());
            System.out.print(node.getValue() + ",");
        }
    }

    private static void nonRecursivePostOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();

        while (true) {
            // try to push nodes which are there in left substree
            if (node != null) {
                // push the node in the stack
                stack.push(node);
                node = node.getLeftNode();
            } else {
                // check if stack is empty
                if (stack.isEmpty()) {
                    break;
                }

                // check of the stack top element's right subtree is null
                if (stack.peek().getRightNode() == null) {
                    node = stack.pop();
                    System.out.print(node.getValue() + ",");

                    // check if the current node is right side of
                    // the node in the stack
                    while (!stack.isEmpty() && node == stack.peek().getRightNode()) {
                        node = stack.pop();
                        System.out.print(node.getValue() + ",");
                    }
                }

                // if stack is empty
                if (stack.isEmpty()) {
                    node = null;
                } else {
                    node = stack.peek().getRightNode();
                }
            }
        }
    }
}
