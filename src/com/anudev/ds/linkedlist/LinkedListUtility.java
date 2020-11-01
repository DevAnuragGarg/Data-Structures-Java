package com.anudev.ds.linkedlist;

public class LinkedListUtility {

    public static LinkedList createLinkedListFromArray(int[] intArray) {
        LinkedList linkedList = new LinkedList();

        for (int i = intArray.length - 1; i >= 0; i--) {
            linkedList.addNode(intArray[i]);
        }
        return linkedList;
    }

    public static void printIntLinkedList(LinkedList linkedList) {
        Node node = linkedList.getRootNode();
        while (node != null) {
            System.out.print(node.getValue() + ",");
            node = node.getNextNode();
        }
    }

    public static void printIntLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.getValue() + ",");
            node = node.getNextNode();
        }
    }
}
