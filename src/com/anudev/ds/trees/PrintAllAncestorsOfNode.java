package com.anudev.ds.trees;

public class PrintAllAncestorsOfNode {

    public static boolean printAncestorsOfNode(Node rootNode, Node findNode) {
        if (rootNode != null) {
            if (rootNode.getValue() == findNode.getValue()) {
                return true;
            }
            if (printAncestorsOfNode(rootNode.getLeftNode(), findNode) || printAncestorsOfNode(rootNode.getRightNode(), findNode)) {
                System.out.print(rootNode.getValue() + ",");
                return true;
            }
        }
        return false;
    }
}
