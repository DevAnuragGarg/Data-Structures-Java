package com.anudev.ds.trees;

/**
 * A full balanced binary search tree where balance factor is 0
 * (meaning difference in the height of left subtree and right subtree
 * should be at most zero).
 * <p>
 * AVL tree(Adelson-Velskii and Landis) is a self balancing tree where the balance factor is 1
 * meaning the difference between left subtree and right subtree is at
 * most 1
 * <p>
 * Min, max number of nodes in AVL Tree: height of AVl tree is h and N(h)
 * indicates number of nodes in AVL tree with height h. Minimum number of
 * nodes with height h is N(h) = N(h-1) + N(h-2) + 1. Maximum number of
 * nodes in a AVL tree can be O(2^h) = O(logn)
 * <p>
 * If we search in a left skewed tree then all the elements need to be
 * compared but if the balanced factor is 0 then only the worst case of
 * time complexity would be equal to height of the tree. So, AVL tree is
 * used to reduce to balanced factor to 1 to make the search easy and fast.
 * <p>
 * Height of AVL tree is always O(Logn)
 * <p>
 * <p>
 * Worst search time complexity in a binary search tree is O(h) where h
 * is the height of the binary tree. height of binary search tree h = Log(n)
 * i.e. number of elements in binary tree.
 * <p>
 * Skewed right binary tree: tree which does not have any left subtree of
 * its children too
 */
public class AVLTree {

    public static AVLNode rootNode;

    public static void insertValue(int value) {
        rootNode = insert(rootNode, value);
        System.out.println("Value inserted into the AVL tree");
    }

    private static AVLNode insert(AVLNode node, int value) {
        /* 1.  Perform the normal BST rotation */
        if (node == null) {
            return (new AVLNode(value));
        }

        // if the value is greater than current node value then add it
        // to right side and if value is smaller than current node value
        // then add it to left side. return the value if found the node
        // to be null as mentioned above
        if (value < node.getValue())
            node.setLeftNode(insert(node.getLeftNode(), value));
        else
            node.setRightNode(insert(node.getRightNode(), value));

        /* 2. Update height of this ancestor node */
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        /* 3. Get the balance factor of this ancestor node to check whether
           this node became unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && value < node.getLeftNode().getValue())
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.getRightNode().getValue())
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.getLeftNode().getValue()) {
            node.setLeftNode(leftRotate(node.getLeftNode()));
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.getRightNode().getValue()) {
            node.setRightNode(rightRotate(node.getRightNode()));
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    private static AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.getLeftNode();
        AVLNode T2 = x.getRightNode();

        // Perform rotation
        x.setRightNode(y);
        y.setLeftNode(T2);

        // Update heights
        y.setHeight(Math.max(height(y.getLeftNode()), height(y.getRightNode())) + 1);
        x.setHeight(Math.max(height(x.getLeftNode()), height(x.getRightNode())) + 1);

        // Return new root
        return x;
    }

    private static AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.getRightNode();
        AVLNode T2 = y.getLeftNode();

        // Perform rotation
        y.setLeftNode(x);
        x.setRightNode(T2);

        //  Update heights
        x.setHeight(Math.max(height(x.getLeftNode()), height(x.getRightNode())) + 1);
        y.setHeight(Math.max(height(y.getLeftNode()), height(y.getRightNode())) + 1);

        // Return new root
        return y;
    }

    private static int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.getHeight();
    }

    // Get Balance factor of node N
    private static int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.getLeftNode()) - height(N.getRightNode());
    }
}
