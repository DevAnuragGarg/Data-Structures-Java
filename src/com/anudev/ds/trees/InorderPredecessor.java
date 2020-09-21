package com.anudev.ds.trees;

public class InorderPredecessor {

    public static void printInorderPredecessor(Node rootNode, int key) {
        Node node = findNode(rootNode, key);

        if (node == null) {
            System.out.println("Invalid key");
            return;
        }
        // if the left node is not null then the node which is having
        // largest value in the left subtree is the inorder predecessor
        // of the node value
        Node predecessorFound;
        if (node.getLeftNode() != null) {
            predecessorFound = findLargestValueOfTree(node.getLeftNode());
        }
        // if the left  node is not present then the node where we
        // have taken last right while reaching the key node is  the
        // inorder predecessor
        else {
            predecessorFound = findLastRightNode(rootNode, key);
        }

        if (predecessorFound != null) {
            System.out.print("Predecessor of node " + key + " is " + predecessorFound.getValue());
        } else {
            System.out.print("No Predecessor of node ");
        }
    }

    private static Node findNode(Node rootNode, int key) {
        Node node = rootNode;
        Node keyNode = null;
        while (true) {
            if (node == null) {
                break;
            } else if (node.getValue() == key) {
                keyNode = node;
                break;
            } else if (node.getValue() > key) {
                node = node.getLeftNode();
            } else {
                node = node.getRightNode();
            }
        }
        return keyNode;
    }

    // find the largest value in subtree
    private static Node findLargestValueOfTree(Node node) {
        while (node.getRightNode() != null) {
            node = node.getRightNode();
        }
        return node;
    }

    // find last right node
    private static Node findLastRightNode(Node rootNode, int key) {
        Node node = rootNode;
        boolean found = false;
        Node lastRightNode = null;
        while (true) {
            if (node == null) {
                break;
            } else if (node.getValue() == key) {
                found = true;
                break;
            } else if (node.getValue() > key) {
                node = node.getLeftNode();
            } else {
                lastRightNode = node;
                node = node.getRightNode();
            }
        }

        // if the element is found then
        if (found) {
            return lastRightNode;
        }
        return null;
    }
}
