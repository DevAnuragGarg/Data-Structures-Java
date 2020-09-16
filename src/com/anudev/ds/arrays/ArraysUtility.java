package com.anudev.ds.arrays;

public class ArraysUtility {


    public static void printIntMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void printIntArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
