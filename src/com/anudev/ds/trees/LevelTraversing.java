package com.anudev.ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelTraversing {

    public static void nonRecursiveLevelTraversal(Node node) {
        System.out.print("Non recursive Level order traversal: ");
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

    public static ArrayList<Node> getLevelOrderedString(Node node) {
        ArrayList<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            list.add(pollNode);

            // add left child
            if (pollNode.getLeftNode() != null) {
                queue.add(pollNode.getLeftNode());
            }

            // add right child
            if (pollNode.getRightNode() != null) {
                queue.add(pollNode.getRightNode());
            }
        }
        return list;
    }
}
