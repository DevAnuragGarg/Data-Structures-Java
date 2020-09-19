package com.anudev.ds.trees;

public class BoundaryTraversalOfTree {

    public static void printBoundaryTraversal(Node node) {
        System.out.print("Boundary traversal: " + node.getValue() + ",");
        printLeftBoundary(node.getLeftNode());
        printRightBoundary(node.getRightNode());
        printLeafNodes(node);
    }

    private static void printLeftBoundary(Node node) {
        if (node != null) {
            if (node.getLeftNode() != null) {
                System.out.print(node.getValue() + ",");
                printLeftBoundary(node.getLeftNode());
            } else if (node.getRightNode() != null) {
                System.out.print(node.getValue() + ",");
                printLeftBoundary(node.getRightNode());
            }
        }
    }

    private static void printRightBoundary(Node node) {
        if (node != null) {
            if (node.getRightNode() != null) {
                System.out.print(node.getValue() + ",");
                printRightBoundary(node.getRightNode());
            } else if (node.getLeftNode() != null) {
                System.out.print(node.getValue() + ",");
                printRightBoundary(node.getLeftNode());
            }
        }
    }


    private static void printLeafNodes(Node node) {
        if (node == null) {
            return;
        }

        if (node.getLeftNode() == null && node.getRightNode() == null) {
            System.out.print(node.getValue() + ",");
        } else {
            printLeafNodes(node.getLeftNode());
            printLeafNodes(node.getRightNode());
        }
    }
}
