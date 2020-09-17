package com.anudev.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNodeOfBinaryTree {

    public static void printDeepestNode(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Node lastNode = null;
        queue.add(node);
        while (!queue.isEmpty()) {
            Node queueNode = queue.poll();

            if (queueNode.getLeftNode() != null) {
                queue.add(queueNode.getLeftNode());
            }

            if (queueNode.getRightNode() != null) {
                queue.add(queueNode.getRightNode());
            }
            lastNode = queueNode;
        }
        System.out.println("Deepest node is having value:\t" + lastNode.getValue());
    }
}
