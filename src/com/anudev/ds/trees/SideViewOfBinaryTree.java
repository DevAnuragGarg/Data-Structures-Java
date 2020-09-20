package com.anudev.ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SideViewOfBinaryTree {

    // to get the left side view do the level order traversal and then
    // take the first element from the level order traversal
    public static void printLeftSideView(Node node) {
        System.out.print("Left side view: ");
        ArrayList<Node> leftSideViewList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        // for end at each level we are going to add null to it.
        queue.add(node);
        leftSideViewList.add(queue.peek());
        queue.add(null);

        while (!queue.isEmpty()) {
            Node queueNode = queue.poll();

            if (queueNode == null) {

                // if the queue is empty just exit
                // if queue is not empty just put the first item after
                // item is found null in the queue.
                if (queue.isEmpty()) {
                    break;
                } else {
                    leftSideViewList.add(queue.peek());
                }
                queue.add(null);
            } else {
                if (queueNode.getLeftNode() != null) {
                    queue.add(queueNode.getLeftNode());
                }
                if (queueNode.getRightNode() != null) {
                    queue.add(queueNode.getRightNode());
                }
            }
        }

        for (Node nodeData : leftSideViewList) {
            System.out.print(nodeData.getValue() + ",");
        }
    }

    // to get the right side view do the level order traversal and then
    // take the last element from the level order traversal
    public static void printRightSideView(Node node) {
        System.out.println();
        System.out.print("Right side view: ");
        Node lastNode = null;
        ArrayList<Node> rightSideViewList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        // for end at each level we are going to add null to it.
        queue.add(node);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node queueNode = queue.poll();

            if (queueNode == null) {

                // if the queue is empty just exit
                // if queue is not empty just put the first item after
                // item is found null in the queue.
                rightSideViewList.add(lastNode);
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            } else {
                if (queueNode.getLeftNode() != null) {
                    queue.add(queueNode.getLeftNode());
                }
                if (queueNode.getRightNode() != null) {
                    queue.add(queueNode.getRightNode());
                }
                lastNode = queueNode;
            }
        }

        for (Node nodeData : rightSideViewList) {
            System.out.print(nodeData.getValue() + ",");
        }
    }
}
