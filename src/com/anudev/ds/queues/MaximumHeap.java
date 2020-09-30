package com.anudev.ds.queues;

/**
 * A PriorityQueue is used when the objects are supposed to be processed
 * based on the priority otherwise first in first out algo as in queue.
 * The elements of the priority queue are ordered according to the
 * natural ordering, or by a Comparator provided at queue construction
 * time, depending on which constructor is used.
 * - PriorityQueue doesn't permit null.
 * - We can't create PriorityQueue of Objects that are non-comparable
 * - PriorityQueue are unbound queues
 * - The head of this queue is the least element with respect to the
 * specified ordering. If multiple elements are tied for least value,
 * the head is one of those elements — ties are broken arbitrarily.
 * - Since PriorityQueue is not thread-safe, so java provides
 * PriorityBlockingQueue class that implements the BlockingQueue
 * interface to use in java multithreading environment.
 * - The queue retrieval operations poll, remove, peek, and element
 * access the element at the head of the queue.
 * - It provides O(log(n)) time for add and poll methods.
 * <p>
 * Priority Queue applications:
 * 1) Huffman coding
 * 2) Dijkstra's algo
 * 3) Prim's algo
 * 4) Find kth smallest element
 * <p>
 * Heap: heap is a tree with some special properties. Value of the node
 * must be greater or less to the values of children. This is called heap
 * property. Also, all the leaves should be at h and h-1 levels (h is height
 * of the tree). There are two heaps: min heap and max heap. Heap is a
 * complete binary tree.
 * <p>
 * Heap can be represented as array
 * binary tree is set in array as per level order traversing
 * if a node is at index i, left child will be at 2*i and right child at
 * 2*i +1 and it's parent will be at i/2.
 * Note: the index starts from 1 not from 0.
 * //               1A
 * //           /       \
 * //         2B         3C
 * //       /   \       /   \
 * //     4D     5E    6F    7G
 * <p>
 * Complete binary tree: A complete binary tree is a binary tree in
 * which every level, except possibly the last, is completely filled,
 * and all nodes are as far left as possible.
 * height of complete binary tree would be log(n)
 * <p>
 * A full binary tree (sometimes proper binary tree or 2-tree) is a tree
 * in which every node other than the leaves has two children.
 * https://www.programiz.com/dsa/complete-binary-tree
 */
public class MaximumHeap {

    private static int[] heapArray = new int[20];
    private static int size = 0;

    public static void insert(int value) {
        System.out.print("Maximum heap tree array: ");
        if (isFull()) {
            return;
        }
        // adding to the last item
        heapArray[size + 1] = value;
        int k = size + 1;
        while (k > 1) {
            // if the parent is greater than child, exchange
            if (heapArray[k] > heapArray[k / 2]) {
                int temp = heapArray[k];
                heapArray[k] = heapArray[k / 2];
                heapArray[k / 2] = temp;
                k /= 2;
            } else {
                break;
            }
        }
        size++;
        printHeapArray();
        System.out.println();
    }

    private static void printHeapArray() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heapArray[i] + ",");
        }
    }

    private static boolean isFull() {
        if (heapArray[heapArray.length - 1] > 0) {
            System.out.println("Heap is already full");
            return true;
        }
        return false;
    }
}
