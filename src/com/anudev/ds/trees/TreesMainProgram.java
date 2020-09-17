package com.anudev.ds.trees;

public class TreesMainProgram {

    public static void main(String[] args) {
        final int[] array = {12, 15, 5, 9, 1, 3, 20, 17, 19, 2, 4, 16};

        // construct and get the root node
        ConstructBinarySearchTree.constructBST(array);
        Node rootNode = ConstructBinarySearchTree.getRootNode();

        // traversal
        PreOrderTraversal.preOrderTraversal(rootNode);
        InOrderTraversal.inOrderTraversal(rootNode);
        PostOrderTraversal.postOrderTraversal(rootNode);
        LevelTraversing.nonRecursiveLevelTraversal(rootNode);

        // traversal
        //PreOrderTraversal.preOrderTraversal(rootNode);
        //InOrderTraversal.inOrderTraversal(rootNode);
        //PostOrderTraversal.postOrderTraversal(rootNode);
    }
}
