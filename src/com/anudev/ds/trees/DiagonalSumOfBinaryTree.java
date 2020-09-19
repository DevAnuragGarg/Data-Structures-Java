package com.anudev.ds.trees;

import java.util.HashMap;

public class DiagonalSumOfBinaryTree {

    private static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void printTheDiagonalSum(Node node) {
        System.out.println("Diagonal sum of binary tree: ");
        calculateDiagonalSum(node, 0);
        printDiagonalSum();
    }

    private static void calculateDiagonalSum(Node node, int hd) {
        if (node == null) {
            return;
        }
        hashMap.put(hd, hashMap.getOrDefault(hd, 0) + node.getValue());
        calculateDiagonalSum(node.getLeftNode(), hd + 1);
        calculateDiagonalSum(node.getRightNode(), hd);
    }

    private static void printDiagonalSum() {
        hashMap.forEach((key, value) -> System.out.println(key + " --------> " + value));
    }
}
