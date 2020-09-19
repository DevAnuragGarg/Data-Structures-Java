package com.anudev.ds.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class BottomViewOfBinaryTree {

    public static void bottomViewOfBinaryTree(Node node) {
        System.out.print("Bottom view of binary tree is: ");
        ArrayList<Node> levelOrderList = LevelTraversing.getLevelOrderedString(node);

        // we can check the hashmap arraylist having the nodes with same
        // hd distance. Node which is coming last in the level order
        // traversing from the arraylist is the node in bottom view. We can
        // also comparing with levelOrderString
        HashMap<Integer, ArrayList<Node>> hashMap = VerticalSumOfTree.getVerticalTraversedHashmap(node);
        Set<Integer> keySet = hashMap.keySet();
        for (Integer key : keySet) {

            // as for the arraylist we are adding the nodes for an HD
            // as per the order. Bottom most at the end so taking
            // the last element so not comparing with level order traversing
            ArrayList<Node> list = hashMap.get(key);
            //System.out.print(list.get(list.size() - 1).getValue() + ",");

            // if we need to compare the list with the level order string
            // to find which element comes last then.
            if (list.size() > 1) {
                // need to check which node in list comes last as per
                // level order string
                Node nodeFound = null;
                int position = Integer.MIN_VALUE;

                for (Node listNode : list) {
                    int currentPosition = levelOrderList.indexOf(listNode);
                    if (position < currentPosition) {
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
