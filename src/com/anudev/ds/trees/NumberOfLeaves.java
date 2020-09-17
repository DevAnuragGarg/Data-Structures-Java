package com.anudev.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfLeaves {

    public static int findNumberOfLeavesRecursively(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.getRightNode() == null && node.getLeftNode() == null) {
            return 1;
        }
        return findNumberOfLeavesRecursively(node.getLeftNode())
                + findNumberOfLeavesRecursively(node.getRightNode());
    }

    public static int findNumberOfLeavesNonRecursively(Node node) {
        int numberOfLeaves = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node queueNode = queue.poll();

            // check if left and right node are null
            if (queueNode.getLeftNode() == null && queueNode.getRightNode() == null) {
                numberOfLeaves++;
            }

            // put right node in queue
            if (queueNode.getRightNode() != null) {
                queue.add(queueNode.getRightNode());
            }

            // put left node in queue
            if (queueNode.getLeftNode() != null) {
                queue.add(queueNode.getLeftNode());
            }
        }
        return numberOfLeaves;
    }
}
