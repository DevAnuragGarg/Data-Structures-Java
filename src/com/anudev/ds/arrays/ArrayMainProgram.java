package com.anudev.ds.arrays;

public class ArrayMainProgram {

    public static void main(String[] args) {

        int[] inputArray = {5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4};

        // next greater element
        NextGreaterElement.printNextGreaterElements(inputArray);
        System.out.println();

        // get minimum element in array
        MinimumValue.findMinimumValue(inputArray);
        System.out.println();

        // leader in the array
        LeaderInArray.findLeaders(inputArray);
        System.out.println();

        // remove duplicates from sorted array with extra space complexity
        RemoveDuplicatesSortedArray.removeDuplicatesWithNSpaceComplexity();

        // remove duplicates from sorted array with no space complexity
        System.out.println("\n");
        RemoveDuplicatesSortedArray.removeDuplicatesWithConstantSpaceComplexity();

        // KMP: finding substring
        System.out.println("\n");
        KMPStringSearchAlgo.searchString();
    }
}
