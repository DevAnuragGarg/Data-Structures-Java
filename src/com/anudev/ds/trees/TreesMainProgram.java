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
        final int[] array2 = {63, 82, 56, 76, 49, 86, 41, 89, 35, 2, 98, 14};

        // construct and get the root node
        ConstructBinarySearchTree.constructBST(array);
        Node rootNode = ConstructBinarySearchTree.getRootNode();

        // construct and get the second root node
        ConstructBinarySearchTree.constructBST(array2);
        Node rootNode2 = ConstructBinarySearchTree.getRootNode();

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

        // Print all the ancestors of tree
        System.out.println("Print all ancestors of node:\t");
        PrintAllAncestorsOfNode.printAncestorsOfNode(rootNode, new Node(16));

        // Lowest common ancestor of two nodes
        System.out.println("\n");
        LowestCommonAncestor.findLowestCommonAncestor(rootNode, new Node(16), new Node(19));

        // print the sum of all the diagonals in binary tree
        DiagonalSumOfBinaryTree.printTheDiagonalSum(rootNode);
        System.out.println();

        // boundary traversal
        BoundaryTraversalOfTree.printBoundaryTraversal(rootNode);
        System.out.println("\n");

        // top view of binary tree
        TopViewOfBinaryTree.topViewOfBinaryTree(rootNode);
        System.out.println("\n");

        // Bottom view of binary tree
        BottomViewOfBinaryTree.bottomViewOfBinaryTree(rootNode);
        System.out.println("\n");

        // Side view of binary tree
        SideViewOfBinaryTree.printLeftSideView(rootNode);
        SideViewOfBinaryTree.printRightSideView(rootNode);
        System.out.println("\n");

        // predecessor of node in a binary tree
        InorderPredecessor.printInorderPredecessor(rootNode, 15);
        System.out.println("\n");

        // successor of node in a binary tree
        InorderSuccessor.printInorderSuccessor(rootNode, 15);
        System.out.println("\n");

        // merge two binary trees
        MergeTwoBST.mergeTwoBST(rootNode, rootNode2);

        // creation AVL trees, insert node and check if balanced
        AVLTree.insertValue(6);
        AVLTree.insertValue(10);
        AVLTree.insertValue(3);
        AVLTree.insertValue(15);
        AVLTree.insertValue(12);
    }
}
