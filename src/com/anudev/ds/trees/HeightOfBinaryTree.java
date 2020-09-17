package com.anudev.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {

    public static int heightOfBinaryTreeRecursively(Node node) {
        if (node == null) {
            return 0;
        }
        int leftSubtreeMaxHeight = heightOfBinaryTreeRecursively(node.getLeftNode());
        int rightSubtreeMaxHeight = heightOfBinaryTreeRecursively(node.getRightNode());
        return 1 + Math.max(leftSubtreeMaxHeight, rightSubtreeMaxHeight);
    }

    public static int heightOfBinaryTreeNonRecursively(Node node) {
        int height = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node queueNode = queue.poll();
            if (queueNode == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                height++;
            } else {

                if (queueNode.getLeftNode() != null) {
                    queue.add(queueNode.getLeftNode());
                }

                if (queueNode.getRightNode() != null) {
                    queue.add(queueNode.getRightNode());
                }
            }
        }
        return height;
    }
}
