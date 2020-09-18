package com.anudev.ds.dynamicprogramming;

/**
 * we first need to take one item at a time and mark as 1 as each item
 * will become a palindrome of length 1 in itself. Then take two items
 * at a time. If it matches you can mark palindrome as 2. Then take 3
 * items at a time. if first and third item does match then it would be
 * 2 + second item palindrome. If not matches then take max(1-2,2-3).
 * Similarly do it for other items
 * <p>
 * Time complexity: O(n2)
 * Space complexity: O(n2)
 */
public class LongestPalindromeSubsequence {

    public static void printLPS(String inputString) {
        // create 2D matrix
        int[][] memoizationMatrix = new int[inputString.length()][inputString.length()];

        // setting the matrix values 1 when taking one char at a time
        for (int i = 0; i < inputString.length(); i++) {
            memoizationMatrix[i][i] = 1;
        }

        // number of times the substring to be taken
        for (int i = 2; i <= inputString.length(); i++) {

            for (int j = 0; j <= inputString.length() - i; j++) {
                int k = i + j - 1;

                if (inputString.charAt(j) == inputString.charAt(k)) {
                    if (i == 2) {
                        memoizationMatrix[j][k] = 2;
                    } else {
                        memoizationMatrix[j][k] = 2 + memoizationMatrix[j + 1][k - 1];
                    }
                } else {
                    memoizationMatrix[j][k] = Math.max(memoizationMatrix[j][k - 1], memoizationMatrix[j + 1][k]);
                }
            }
        }
        System.out.println("Length of LPS is: " + memoizationMatrix[0][inputString.length() - 1]);
    }
}
