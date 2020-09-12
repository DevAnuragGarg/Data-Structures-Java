package com.anudev.ds.dynamicprogramming;

/**
 * Given two sequences, find the length of longest subsequence present
 * in both of them. A subsequence is a sequence that appears in the same
 * relative order, but not necessarily contiguous. For example, “abc”,
 * “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * <p>
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * <p>
 * Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters
 * match for the strings. So length of LCS can be written as:
 * L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)
 * Consider the input strings “ABCDGH” and “AEDFHR. Last characters do
 * not match for the strings. So length of LCS can be written as:
 * L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )
 */

public class LongestCommonSubsequence {
    private final String sequence1 = "AGGTAB";
    private final String sequence2 = "GXTXAYB";

    public void lengthOfLongestCommonSubsequence() {
        // we will create a 2-d array having the rows as per sequence 1
        // and columns as per sequence 2. adding the first column and 1st
        // row as dummy with 0 values.
        int[][] tempArray = new int[sequence1.length() + 1][sequence2.length() + 1];

        for (int i = 1; i < sequence1.length() + 1; i++) {

            for (int j = 1; j < sequence2.length() + 1; j++) {
                // if the character matches
                if (sequence1.charAt(i - 1) == sequence2.charAt(j - 1)) {
                    // increment the diagonal value with 1 and put in temp array
                    // basically it means: 1 + L(“AGGTA”, “GXTXAY”)
                    tempArray[i][j] = 1 + tempArray[i - 1][j - 1];
                } else {
                    // take the max of above cell or left cell
                    // get MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )
                    tempArray[i][j] = Math.max(tempArray[i][j - 1], tempArray[i - 1][j]);
                }
            }
        }

        int longestSubsequenceLength = tempArray[sequence1.length()][sequence2.length()];
        System.out.println("Longest subsequence length is " + longestSubsequenceLength);
        printSequence(tempArray);
    }

    private void printSequence(int[][] array) {
        String sequence = "";
        int row = sequence1.length();
        int column = sequence2.length();
        int longestSubsequenceLength = array[row][column];
        if (longestSubsequenceLength > 0) {
            while (row != 0 && column != 0) {
                if (array[row][column] != array[row - 1][column] && array[row][column] != array[row][column - 1]) {
                    sequence = String.valueOf(sequence1.charAt(row - 1)).concat(sequence);
                    row--;
                    column--;
                } else if (array[row][column] == array[row - 1][column]) {
                    row--;
                } else if (array[row][column] == array[row][column - 1]) {
                    column--;
                }
            }
        }
        System.out.println("Sequence is " + sequence);
    }
}

