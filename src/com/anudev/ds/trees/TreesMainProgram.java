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

        // height of tree
        System.out.println();
        System.out.println("Height of Tree Recursively:\t\t" + HeightOfBinaryTree.heightOfBinaryTreeRecursively(rootNode));
        System.out.println("Height of Tree Non Recursively:\t" + HeightOfBinaryTree.heightOfBinaryTreeNonRecursively(rootNode));

        // size of binary tree
        System.out.println("Size of Tree Recursively:\t\t" + SizeOfBinaryTree.sizeOfBinaryTreeRecursively(rootNode));
        System.out.println("Size of Tree Non Recursively:\t" + SizeOfBinaryTree.sizeOfBinaryTreeNonRecursively(rootNode));

        // traversal
        //PreOrderTraversal.preOrderTraversal(rootNode);
        //InOrderTraversal.inOrderTraversal(rootNode);
        //PostOrderTraversal.postOrderTraversal(rootNode);
    }
}
