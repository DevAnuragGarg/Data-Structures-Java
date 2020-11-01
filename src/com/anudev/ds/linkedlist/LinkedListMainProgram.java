package com.anudev.ds.linkedlist;

import com.anudev.ds.trees.ConstructBinarySearchTree;

public class LinkedListMainProgram {

    public static void main(String[] args) {

        final int[] array = {12, 15, 5, 9, 1, 3, 20, 17, 19, 2, 4, 16};

        // construct and get the root node
        ConstructBinarySearchTree.constructBST(array);
        com.anudev.ds.trees.Node rootNode = ConstructBinarySearchTree.getRootNode();

        // Binary tree to doubly linked list
        // it will be printing in reverse as per the linked list creation
        Node node = BinaryTreeToDoublyLinkedList.binaryToDoublyLinkedListBreadth(rootNode);
        LinkedListUtility.printIntLinkedList(node);
    }
}
