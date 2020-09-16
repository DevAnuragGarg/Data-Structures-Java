package com.anudev.ds.trees;

public class ConstructBinarySearchTree {

    private static Node rootNode;

    public static void constructBST(int[] array) {
        rootNode = new Node(array[0]);

        for (int i = 1; i < array.length; i++) {
            Node node = rootNode;

            while (true) {
                int value = node.getValue();

                if (value < array[i]) {
                    if (node.getRightNode() != null) {
                        node = node.getRightNode();
                    } else {
                        node.setRightNode(new Node(array[i]));
                        break;
                    }
                } else {
                    if (node.getLeftNode() != null) {
                        node = node.getLeftNode();
                    } else {
                        node.setLeftNode(new Node(array[i]));
                        break;
                    }
                }
            }
        }
        System.out.println("BST created");
    }

    public static Node getRootNode() {
        return rootNode;
    }
}
