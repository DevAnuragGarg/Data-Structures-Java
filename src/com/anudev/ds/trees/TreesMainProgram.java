package com.anudev.ds.trees;

/**
 * Tree for the below mentioned array
 * <p>
 * //            12
 * //         /       \
 * //       5         15
 * //     /   \         \
 * //    1     9         20
 * //     \             /
 * //      3          17
 * //     / \        /  \
 * //    2   4     16    19
 */

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
        System.out.println("\n");

        // height of tree
        System.out.println("Height of Tree Recursively:\t\t" + HeightOfBinaryTree.heightOfBinaryTreeRecursively(rootNode));
        System.out.println("Height of Tree Non Recursively:\t" + HeightOfBinaryTree.heightOfBinaryTreeNonRecursively(rootNode));
        System.out.println();

        // size of binary tree
        System.out.println("Size of Tree Recursively:\t\t" + SizeOfBinaryTree.sizeOfBinaryTreeRecursively(rootNode));
        System.out.println("Size of Tree Non Recursively:\t" + SizeOfBinaryTree.sizeOfBinaryTreeNonRecursively(rootNode));
        System.out.println();

        // deepest node of binary tree
        DeepestNodeOfBinaryTree.printDeepestNode(rootNode);
        System.out.println();

        // Number of leaves
        System.out.println("Number of Leaves in tree Recursively:\t\t" + NumberOfLeaves.findNumberOfLeavesRecursively(rootNode));
        System.out.println("Number of Leaves in tree Non Recursively:\t" + NumberOfLeaves.findNumberOfLeavesNonRecursively(rootNode));
        System.out.println();

        // diameter of the tree
        System.out.println("Diameter of the tree is: " + DiameterOfTree.diameterOfTree(rootNode));
        System.out.println();

        // vertical sum of the tree
        VerticalSumOfTree.printTheVerticalSum(rootNode);
        System.out.println();

        // print root to leaf paths
        PrintEachRootToLeafPath.printAllPaths(rootNode);
        System.out.println();
    }
}
