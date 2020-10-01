package com.anudev.ds.trees;

/**
 * It is like AVL tree is self balancing binary tree. Time complexity
 * of Red black operations is similar to AVL trees but balancing condition
 * in red black tree is restrictive that's why we have less rotations,
 * that's why red black tree is more preferred than avl trees. Ex of
 * red black tree are treemap or sortedmap in java.
 * <p>
 * Red black tree is binary search tree. Nodes of Red-Black tree are either
 * red or black. Root is always black node. There is no red-red parent
 * child relationship. Number of black nodes from root to node with less
 * then 2 children is same.
 * <p>
 * Rules for insertion of node:
 * 1) If empty tree create black root node.
 * 2) Insert new node as red
 * a) if parent is black then done
 * b) if parent is red:
 * - if black or absent sibling: rotate, reorder is done.
 * - if red sibling then reorder and check again.
 */
public class RedBlackTree {
}
