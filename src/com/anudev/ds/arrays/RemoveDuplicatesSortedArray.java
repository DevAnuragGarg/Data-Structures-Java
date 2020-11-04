package com.anudev.ds.arrays;

/**
 * remove duplicates from sorted array
 *
 * 1) 1st way
 * O(n) time complexity
 * O(n) space complexity
 *
 * 2) 2nd way
 * O(n) time complexity
 * 1 space complexity
 *
 */
public class RemoveDuplicatesSortedArray {

    public static void removeDuplicatesWithNSpaceComplexity() {
        int[] array = {1, 2, 2, 3, 3, 4, 4, 4, 5};
        int[] tempArray = new int[array.length];
        int previousValue = array[0];
        tempArray[0] = previousValue;
        int size = 1;
        for (int i = 1; i < array.length; i++) {
            if (previousValue != array[i]) {
                previousValue = array[i];
                tempArray[size++] = array[i];
            }
        }

        System.out.println("Array after removing duplicates with extra space complexity");
        for (int i = 0; i < size; i++) {
            System.out.print(tempArray[i] + ", ");
        }
    }

    public static void removeDuplicatesWithConstantSpaceComplexity() {
        int[] array = {1, 2, 2, 3, 3, 4, 4, 4, 5};
        int size = 1;
        for (int i = 0, j = 1; j < array.length; ) {
            if (array[i] != array[j]) {
                array[++i] = array[j++];
                size++;
            } else {
                j++;
            }
        }

        System.out.println("Array after removing duplicates with constant space complexity");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + ", ");
        }
    }
}
