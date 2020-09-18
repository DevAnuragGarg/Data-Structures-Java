package com.anudev.ds.trees;

import java.util.LinkedList;

public class PrintEachRootToLeafPath {

    public static LinkedList<Node> linkedList = new LinkedList();

    public static void printAllPaths(Node node) {
        System.out.println("All root to leaf paths: ");
        findAllRootToLeafPath(node);
    }

    private static void findAllRootToLeafPath(Node node) {

        if (node == null) {
            return;
        }

        // add to linked list
        linkedList.add(node);

        if (node.getLeftNode() == null && node.getRightNode() == null) {
            printLinkedList();
        } else {
            findAllRootToLeafPath(node.getLeftNode());
            findAllRootToLeafPath(node.getRightNode());
        }
        linkedList.removeLast();
    }

    private static void printLinkedList() {
        for (Node node : linkedList) {
            System.out.print(node.getValue() + ",");
        }
        System.out.println();
    }
}
