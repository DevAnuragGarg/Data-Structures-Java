package com.anudev.ds.arrays;

public class ArrayMainProgram {

    public static void main(String[] args) {

        int[] inputArray = {5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4};

        // next greater element
        NextGreaterElement.printNextGreaterElements(inputArray);
        System.out.println("\n");

        // get minimum element in array
        MinimumValue.findMinimumValue(inputArray);
    }
}
