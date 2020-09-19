package com.anudev.ds.trees;

public class LowestCommonAncestor {

    public static Node findLowestCommonAncestor(Node rootNode, Node firstNode, Node secondNode) {
        if (rootNode == null) {
            return null;
        }

        if (rootNode.getValue() == firstNode.getValue()
                || rootNode.getValue() == secondNode.getValue()) {
            return rootNode;
        }

        Node leftNodeFound = findLowestCommonAncestor(rootNode.getLeftNode(), firstNode, secondNode);
        Node rightNodeFound = findLowestCommonAncestor(rootNode.getRightNode(), firstNode, secondNode);

        if (leftNodeFound != null && rightNodeFound != null) {
            System.out.println("Lowest common Ancestor of "
                    + firstNode.getValue() + " and "
                    + secondNode.getValue() + " is " + rootNode.getValue());
        } else if (leftNodeFound != null) {
            return leftNodeFound;
        } else return rightNodeFound;
        return null;
    }
}
