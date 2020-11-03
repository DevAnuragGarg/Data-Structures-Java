package com.anudev.ds.dynamicprogramming;

import com.anudev.ds.arrays.ArraysUtility;

/*
 * Finding all the prime numbers
 * we wil create an array of that number. When we reach a number we will start
 * marking down the multiple of that number starting from the square of that
 * number. If the square of that number becomes greater than the maximum number
 * n we will stop and all the numbers which are left are the prime number.
 */
public class SeiveOfEratosthenes {

    private final int primeTillNumber = 100;

    private int[] tempArray;

    public void printPrimeNumbers() {
        seiveOfEratosthenesAlgo();
        ArraysUtility.printIntArray(tempArray);
    }

    private void seiveOfEratosthenesAlgo() {
        tempArray = new int[primeTillNumber - 1];

        // insert value in temp array
        for (int i = 2; i <= primeTillNumber; i++) {
            tempArray[i - 2] = i;
        }

        int maximumSqrtValueOfN = (int) Math.sqrt(primeTillNumber);

        // we will run till the square root of max value
        for (int i = 0; i <= maximumSqrtValueOfN - 1; i++) {
            int value = tempArray[i];

            // checking if the value is not zero
            // starting from square of the value with multiple of value making it 0
            if (value != 0) {
                for (int j = value * value; j <= primeTillNumber; j = j + value) {
                    tempArray[j - 2] = 0;
                }
            }
        }
    }
}
