package com.anudev.ds.trees;

public class TreeDummyData {

    // Tree with level order traversal as 1, 2, 3, 4, 5 .... 15
    private static Node rootNode;

    public static Node getRootNode() {
        if (rootNode == null) {
            prepareLevelOrderTree();
        }
        return rootNode;
    }

    private static void prepareLevelOrderTree() {
        rootNode = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);

        // setting the left nodes
        rootNode.setLeftNode(node2);
        node2.setLeftNode(node4);
        node4.setLeftNode(node8);
        node5.setLeftNode(node10);
        node3.setLeftNode(node6);
        node6.setLeftNode(node12);
        node7.setLeftNode(node14);

        // setting the right node
        rootNode.setRightNode(node3);
        node2.setRightNode(node5);
        node4.setRightNode(node9);
        node5.setRightNode(node11);
        node3.setRightNode(node7);
        node6.setRightNode(node13);
        node7.setRightNode(node15);
    }
}
