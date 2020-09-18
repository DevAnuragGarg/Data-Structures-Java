package com.anudev.ds.trees;

/**
 * Diameter of tree is the length of the longest path between any two
 * nodes in a tree. The path may or may not pass through root.
 * <p>
 * As path may not pass through root, so for each node we need to check
 * for each node
 * 1) when include the node as root itself: value of 1 + height(leftSubtree) + height(rightSubtree)
 * 2) when we exclude the node as root: max(diameter(leftSubtree), diameter(rightSubtree))
 * <p>
 * And we need to find the maximum of these two for each node
 */
public class DiameterOfTree {

    public static int diameterOfTree(Node node) {
        if (node == null) {
            return 0;
        }
        int heightLeftSubtree = HeightOfBinaryTree.heightOfBinaryTreeRecursively(node.getLeftNode());
        int heightRightSubtree = HeightOfBinaryTree.heightOfBinaryTreeRecursively(node.getRightNode());

        // including the root node
        int diameterIncludingRoot = 1 + heightLeftSubtree + heightRightSubtree;

        // excluding the root node
        int maxDiameterOfLeftRightSubtree = Math.max(diameterOfTree(node.getLeftNode()), diameterOfTree(node.getRightNode()));

        return Math.max(diameterIncludingRoot, maxDiameterOfLeftRightSubtree);
    }
}
