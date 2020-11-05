package com.anudev.ds.arrays;

/**
 * searching a pattern in a string. There is a naive method which will
 * lead to worst case complexity as O(m(n-m+1)). it can be reduced to
 * O(n). basic idea is whenever there is a mismatch(after some matches),
 * we already know some of the characters in the next window. so we try
 * to avoid matching of the characters
 * <p>
 * KMP: Knuth Morris Pratt: In this we will try to find out the string
 * which is the suffix as well the prefix of the substring(which is matched)
 * which is to be searched
 * Ex. acbacdabcy in acbacxabcdabx... here when we search the string
 * first part matches is acbac. Now we find the substring of this string
 * which suffix as well as prefix of this substring. Here that substring
 * is ac.
 * Now efficiently find out the suffix as prefix of the substring.
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
 */
public class KMPStringSearchAlgo {

    private static int[] tempArray;
    private static final String pattern = "abcaby";
    private static final String text = "abxabcabcaby";

    public static void searchString() {
        tempArray = new int[pattern.length()];
        buildTempArrayWithSuffixPrefix();

        int i = 0, j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = tempArray[j - 1];
                } else {
                    i++;
                }
            }
        }

        // check if reached to the end
        if (j == pattern.length()) {
            System.out.println("Substring found");
        } else {
            System.out.println("No substring found");
        }
    }

    private static void buildTempArrayWithSuffixPrefix() {
        // comparing each char
        int index = 0;
        for (int i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                tempArray[i++] = index + 1;
                index++;
            } else {
                if (index != 0) {
                    index = tempArray[index - 1];
                } else {
                    i++;
                }
            }
        }
    }
}
