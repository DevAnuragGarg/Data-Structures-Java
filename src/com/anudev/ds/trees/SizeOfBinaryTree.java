package com.anudev.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTree {

    public static int sizeOfBinaryTreeRecursively(Node node) {
        if (node == null) {
            return 0;
        }
        return sizeOfBinaryTreeRecursively(node.getLeftNode()) + 1 +
                sizeOfBinaryTreeRecursively(node.getRightNode());
    }

    public static int sizeOfBinaryTreeNonRecursively(Node node) {
        int size = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node queueNode = queue.poll();

            if (queueNode.getLeftNode() != null) {
                queue.add(queueNode.getLeftNode());
                size++;
            }

            if (queueNode.getRightNode() != null) {
                queue.add(queueNode.getRightNode());
                size++;
            }
        }
        return size;
    }
}
