package com.anudev.ds.arrays;

/**
 * A leader in an array: for a leader L all the elements on the right
 * side of L are less than L.
 */
public class LeaderInArray {

    public static void findLeaders(int[] array) {
        // we will start from right, if the element is the
        // maximum element found till now in the array, that element
        // will become the leader
        int leader = 0;

        for (int i = array.length - 1; i > -1; i--) {
            if (array[i] > leader) {
                leader = array[i];
                System.out.println("Leader in array is: " + array[i]);
            }
        }
    }
}
