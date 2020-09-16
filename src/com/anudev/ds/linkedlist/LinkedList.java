package com.anudev.ds.linkedlist;

public class LinkedList<T> {
    private Node<T> rootNode;

    public Node<T> getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node<T> rootNode) {
        this.rootNode = rootNode;
    }

    // add the node
    public void addNode(T value) {
        Node<T> node = new Node<>(value);

        if (rootNode != null) {
            node.setNextNode(rootNode);
        }
        rootNode = node;
    }
}
