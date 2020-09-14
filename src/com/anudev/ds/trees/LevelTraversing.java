package com.anudev.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelTraversing {

    public void printLevelOrderTraversing() {
        nonRecursiveLevelTraversal(TreeDummyData.getRootNode());
    }

    private void nonRecursiveLevelTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            System.out.print(pollNode.getValue() + ",");

            // add left child
            if (pollNode.getLeftNode() != null) {
                queue.add(pollNode.getLeftNode());
            }

            // add right child
            if (pollNode.getRightNode() != null) {
                queue.add(pollNode.getRightNode());
            }
        }
    }
}
