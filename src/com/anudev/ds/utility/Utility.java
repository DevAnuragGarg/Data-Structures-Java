package com.anudev.ds.utility;

public class Utility {

    public static void printIntMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
