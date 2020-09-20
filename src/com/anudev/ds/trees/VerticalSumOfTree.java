package com.anudev.ds.trees;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * for vertical sum of tree we need to keep a value HD with each node
 * If going to left subtree of that node then subtract the HD by 1 and
 * if it goes to right then add the HD by one. We keep maintaining
 * using the hashmap having key as the HD and value as the sum of
 * the values of the nodes having that HD.
 */
public class VerticalSumOfTree {

    private static final HashMap<Integer, Integer> hashMap = new HashMap<>();
    private static final HashMap<Integer, ArrayList<Node>> verticalTraversedHashMap = new HashMap<>();

    public static void printTheVerticalSum(Node node) {
        System.out.println("Vertical sum of binary tree: ");
        calculateVerticalSum(node, 0);
        printVerticalSum();
    }

    private static void calculateVerticalSum(Node node, int hd) {
        if (node == null) {
            return;
        }
        hashMap.put(hd, hashMap.getOrDefault(hd, 0) + node.getValue());
        ArrayList<Node> list = verticalTraversedHashMap.getOrDefault(hd, new ArrayList<>());
        list.add(node);
        verticalTraversedHashMap.put(hd, list);
        calculateVerticalSum(node.getLeftNode(), hd - 1);
        calculateVerticalSum(node.getRightNode(), hd + 1);
    }

    private static void printVerticalSum() {
        hashMap.forEach((key, value) -> System.out.println(key + " --------> " + value));
    }

    /**
     * for generating the hashmap having the list of nodes for particular
     * vertical distance
     *
     * @param node
     * @return
     */
    public static HashMap<Integer, ArrayList<Node>> getVerticalTraversedHashmap(Node node) {
        verticalTraversedHashMap.clear();
        generateHashmap(node, 0);
        return verticalTraversedHashMap;
    }

    public static void generateHashmap(Node node, int hd) {
        if (node == null) {
            return;
        }
        ArrayList<Node> list = verticalTraversedHashMap.getOrDefault(hd, new ArrayList<>());
        list.add(node);
        verticalTraversedHashMap.put(hd, list);
        calculateVerticalSum(node.getLeftNode(), hd - 1);
        calculateVerticalSum(node.getRightNode(), hd + 1);
    }
}
