package com.anudev.ds.trees;

public class InorderSuccessor {

    public static void printInorderSuccessor(Node rootNode, int key) {
        Node node = findNode(rootNode, key);

        if (node == null) {
            System.out.println("Invalid key");
            return;
        }
        // if the right node is not null then the node which is having
        // smallest value in the left subtree is the inorder successor
        // of the node value
        Node successorFound;
        if (node.getRightNode() != null) {
            successorFound = findSmallestValueOfTree(node.getRightNode());
        }
        // if the left  node is not present then the node where we
        // have taken last right while reaching the key node is  the
        // inorder predecessor
        else {
            successorFound = findLastLeftNode(rootNode, key);
        }

        if (successorFound != null) {
            System.out.print("Successor of node " + key + " is " + successorFound.getValue());
        } else {
            System.out.print("No successor of node ");
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

    // find the smallest value in subtree
    private static Node findSmallestValueOfTree(Node node) {
        while (node.getLeftNode() != null) {
            node = node.getLeftNode();
        }
        return node;
    }

    // find last left node
    private static Node findLastLeftNode(Node rootNode, int key) {
        Node node = rootNode;
        boolean found = false;
        Node lastLeftNode = null;
        while (true) {
            if (node == null) {
                break;
            } else if (node.getValue() == key) {
                found = true;
                break;
            } else if (node.getValue() > key) {
                lastLeftNode = node;
                node = node.getLeftNode();
            } else {
                node = node.getRightNode();
            }
        }

        // if the element is found then
        if (found) {
            return lastLeftNode;
        }
        return null;
    }
}
