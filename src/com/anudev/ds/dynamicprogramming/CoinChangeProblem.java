package com.anudev.ds.dynamicprogramming;

import com.anudev.ds.arrays.ArraysUtility;

/**
 * You are given unlimited supply coins of some denominations
 * and you have to find a sum. Find the number of ways you can
 * achieve using the coins
 */
public class CoinChangeProblem {

    private final int sumValue = 8;
    private final int[] coinDenominations = {1, 2, 3, 5};

    private int[][] memMatrix;

    public void findTheSumValue() {
        createMemoizationMatrix();
        findAndPrintValue();
    }

    private void createMemoizationMatrix() {
        int[] coinValues = new int[coinDenominations.length + 1];
        for (int i = 1; i < coinValues.length; i++) {
            coinValues[i] = coinDenominations[i - 1];
        }
        memMatrix = new int[coinValues.length][sumValue + 1];

        // putting value for making sum 0 from 0 coin denomination as 1
        // number of ways in making the sum 0 with 0 coin is 1: hypothetical
        memMatrix[0][0] = 1;

        for (int i = 1; i < memMatrix.length; i++) {

            for (int j = 0; j < memMatrix[0].length; j++) {

                if (coinValues[i] > j) {
                    memMatrix[i][j] = memMatrix[i - 1][j];
                } else {
                    // case where current denomination coin is included
                    // : matrix[coins included denomination][sum - current value denomination coin used]
                    // +
                    // case where current denomination coin is excluded
                    // : matrix[coins excluded denomination][current sum required]
                    memMatrix[i][j] = memMatrix[i][j - coinValues[i]]
                            + memMatrix[i - 1][j];
                }
            }
        }
        ArraysUtility.printIntMatrix(memMatrix);
    }

    private void findAndPrintValue() {
        System.out.println();
        System.out.println("Number of ways are: " + memMatrix[coinDenominations.length][sumValue]);
    }
}
