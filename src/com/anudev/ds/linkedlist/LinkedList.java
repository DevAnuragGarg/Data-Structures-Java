package com.anudev.ds.linkedlist;

public class LinkedList {
    private Node rootNode;

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    // add the node
    public void addNode(int value) {
        Node node = new Node(value);

        if (rootNode != null) {
            node.setNextNode(rootNode);
        }
        rootNode = node;
    }

    // add the node
    public void addNodeDLL(int value) {
        Node node = new Node(value);

        if (rootNode != null) {
            node.setNextNode(rootNode);
            rootNode.setPreviousNode(node);
        }
        rootNode = node;
    }
}
