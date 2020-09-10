package com.anudev.ds.dynamicprogramming;

import com.anudev.ds.utility.Utility;

/**
 * You are given unlimited supply coins of some denominations
 * and you have to find a sum. Find the number of ways you can
 * achieve using the coins
 */
public class CoinChangeProblem {

    private int sumValue = 8;
    private int[][] memMatrix;
    private int[] coinDenominations = {1, 2, 3, 5};

    public void findTheSumValue() {
        createMemoizationMatrix();
    }

    private void createMemoizationMatrix() {
        int[] coinValues = new int[coinDenominations.length + 1];
        for (int i = 1; i < coinValues.length; i++) {
            coinValues[i] = coinDenominations[i - 1];
        }
        memMatrix = new int[coinValues.length][sumValue + 1];

        // putting value for making sum 0 from 0 coin denomination as 1
        memMatrix[0][0] = 1;

        for (int i = 1; i < memMatrix.length; i++) {

            for (int j = 0; j < memMatrix[0].length; j++) {

                if (coinValues[i] > j) {
                    memMatrix[i][j] = memMatrix[i - 1][j];
                } else {
                    // including + excluding
                    memMatrix[i][j] = memMatrix[i][j - coinValues[i]]
                            + memMatrix[i - 1][j];
                }
            }
        }
        Utility.printIntMatrix(memMatrix);
    }
}
