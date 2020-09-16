package com.anudev.ds.dynamicprogramming;

import com.anudev.ds.arrays.ArraysUtility;

/**
 * You are given unlimited supply coins of some denominations
 * and you have to find a value sum using those denominations with
 * minimum number of coins
 */
public class CoinChangeProblem2 {


    private int sumValue = 8;
    private int[][] memMatrix;
    private int[] coinDenominations = {1, 2, 3, 5};

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

        for (int i = 1; i < memMatrix.length; i++) {

            for (int j = 0; j < memMatrix[0].length; j++) {

                if (coinValues[i] > j) {
                    memMatrix[i][j] = memMatrix[i - 1][j];
                } else {
                    // included denomination
                    // (counting coins: 1(using current denomination coin)
                    // + matrix value[current denomination][sum - current value of denomination])
                    int includedDenominationCoinsRequired = 1 + memMatrix[i][j - coinValues[i]];

                    // excluded denomination
                    int excludedDenominationCoinsRequired = memMatrix[i - 1][j];

                    if (excludedDenominationCoinsRequired != 0) {
                        memMatrix[i][j] = Math.min(includedDenominationCoinsRequired, excludedDenominationCoinsRequired);
                    } else {
                        memMatrix[i][j] = includedDenominationCoinsRequired;
                    }
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
