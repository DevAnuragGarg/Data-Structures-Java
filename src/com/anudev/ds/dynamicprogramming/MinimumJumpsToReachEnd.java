package com.anudev.ds.dynamicprogramming;

/**
 * You are given the array with some values and when you reach that
 * index you can jump only that much indexes. Find the minimum number
 * of jumps needed to reach the end of the array
 * <p>
 * Value at index will give you maximum length of jump. For this we will
 * create two separate arrays. 1 for the minimum number of jumps
 * required to reach that particular index and second the index from
 * where we can reach that index
 */
public class MinimumJumpsToReachEnd {

    public static void minimumJumpsToReachEnd() {
        int[] array = new int[]{2, 1, 3, 2, 3, 4, 5, 1, 2, 8};
        int[] path = new int[array.length];
        int[] numberOfJumps = new int[array.length];

        // this will be hardcoded as reaching the first you don't
        // need to jump. You can leave it also, as by default it would
        // be 0 during initialization
        numberOfJumps[0] = 0;
        // we will have two loops
        // one for the going from 2nd element to last element
        // one for each value of above loop go from starting to that
        // particular index to check if there is a way to reach
        // the desired destination or not.
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                // means value at jth index can jump directly to ith index
                if (j + array[j] >= i) {
                    if (numberOfJumps[i] == 0 || numberOfJumps[i] > 1 + numberOfJumps[j]) {
                        numberOfJumps[i] = 1 + numberOfJumps[j];
                        path[i] = j;
                    }
                }
            }
        }

        System.out.println("Minimum number of jumps needed are: " + numberOfJumps[array.length - 1]);
        int value = array.length - 1;
        System.out.print(value);
        while (value != 0) {
            value = path[value];
            System.out.print(", " + value);
        }
    }
}
