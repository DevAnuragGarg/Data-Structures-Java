package com.anudev.ds.arrays;

/**
 * Find the minimum value in array
 */
public class MinimumValue {

    public static void findMinimumValue(int[] array) {
        int minimumValue = Integer.MAX_VALUE;
        for (int i : array) {
            if (minimumValue > i) {
                minimumValue = i;
            }
        }
        System.out.println("Minimum value in array is: " + minimumValue);
    }
}
