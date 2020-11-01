package com.anudev.ds.linkedlist;

import com.anudev.ds.trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToDoublyLinkedList {

    public static com.anudev.ds.linkedlist.Node binaryToDoublyLinkedListBreadth(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        com.anudev.ds.linkedlist.LinkedList linkedList = new com.anudev.ds.linkedlist.LinkedList();

        while (!queue.isEmpty()) {
            Node queueNode = queue.poll();
            linkedList.addNodeDLL(queueNode.getValue());

            if (queueNode.getLeftNode() != null) {
                queue.add(queueNode.getLeftNode());
            }

            if (queueNode.getRightNode() != null) {
                queue.add(queueNode.getRightNode());
            }
        }

        return linkedList.getRootNode();
    }
}
