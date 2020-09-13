package com.anudev.ds.trees;

public class ConstructBinarySearchTree {

    private final int[] array = {12, 15, 5, 9, 1, 3, 20, 17, 19, 2, 4, 16};
    private Node rootNode;

    public void createBST() {
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
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        preOrderTraversal.preOrderTraversal(rootNode);

        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.inOrderTraversal(rootNode);
    }
}
