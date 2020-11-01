package com.anudev.ds.arrays;

import java.util.Stack;

/**
 * Find the next greater element in array. If not present then
 * print null. While iterating the array, we put the index of the
 * value in the stack when 1) stack is empty 2) last entered index in
 * the stack is greater than the current index value. If the value of
 * last entered index is less than the current the next greater element
 * for the last entered index would be current value and we keep popping
 * till the condition is met.
 * https://www.geeksforgeeks.org/next-greater-element/
 */
public class NextGreaterElement {

    public static void printNextGreaterElements(int[] inputArray) {
        int[] tempArray = new int[inputArray.length];

        // creating a stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inputArray.length; i++) {
            while (!stack.isEmpty() && inputArray[i] > inputArray[stack.peek()]) {
                tempArray[stack.pop()] = inputArray[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            tempArray[stack.pop()] = -1;
        }

        // print value
        for (int i = 0; i < inputArray.length; i++) {
            if (tempArray[i] != -1) {
                System.out.println("Next greater element for " + inputArray[i] + " ---> " + tempArray[i]);
            } else {
                System.out.println("Next greater element for " + inputArray[i] + " ---> null");
            }
        }
    }
}
