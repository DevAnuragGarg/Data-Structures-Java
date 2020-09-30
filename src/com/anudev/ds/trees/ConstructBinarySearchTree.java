package com.anudev.ds.trees;

/**
 * Worst search time complexity in a binary search tree is O(h) where h
 * is the height of the binary tree. height of binary search tree h = Log(n)
 * i.e. number of elements in binary tree.
 *
 * Skewed right binary tree: tree which does not have any left subtree of
 * its children too
 */
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
