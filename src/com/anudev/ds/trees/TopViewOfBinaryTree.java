package com.anudev.ds.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TopViewOfBinaryTree {

    public static void topViewOfBinaryTree(Node node) {
        System.out.print("Top view of binary tree is: ");
        ArrayList<Node> levelOrderList = LevelTraversing.getLevelOrderedString(node);

        // we can check the hashmap arraylist having the nodes with same
        // hd distance. Node which is coming first in the level order
        // traversing from the arraylist is the node in top view. We can
        // also comparing with levelOrderString
        HashMap<Integer, ArrayList<Node>> hashMap = VerticalSumOfTree.getVerticalTraversedHashmap(node);
        Set<Integer> keySet = hashMap.keySet();
        for (Integer key : keySet) {

            // as for the arraylist we are adding the nodes for an HD
            // as per the order. Top most at the starting so taking
            // the first element so not comparing with level order traversing
            // System.out.print(hashMap.get(key).get(0).getValue() + ",");

            // if we need to compare the list with the level order string
            // to find which element comes first then.
            ArrayList<Node> list = hashMap.get(key);
            if (list.size() > 1) {
                // need to check which node in list comes first as per
                // level order string
                Node nodeFound = null;
                int position = Integer.MAX_VALUE;
                for (Node listNode : list) {
                    int currentPosition = levelOrderList.indexOf(listNode);
                    if (position > currentPosition) {
                        position = currentPosition;
                        nodeFound = listNode;
                    }
                }
                System.out.print(nodeFound.getValue() + ",");
            } else {
                System.out.print(list.get(0).getValue() + ",");
            }
        }
    }
}
