package com.anudev.ds.linkedlist;

public class LinkedListUtility {

    public LinkedList<Integer> createLinkedListFromArray(int[] intArray) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = intArray.length - 1; i >= 0; i--) {
            linkedList.addNode(intArray[i]);
        }
        return linkedList;
    }

    public void printIntLinkedList(LinkedList<Integer> linkedList) {
        Node<Integer> node = linkedList.getRootNode();
        while (node != null) {
            System.out.print(node.getValue() + ",");
            node = node.getNextNode();
        }
    }
}
