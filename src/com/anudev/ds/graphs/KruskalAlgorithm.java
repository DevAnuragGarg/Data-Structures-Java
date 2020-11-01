package com.anudev.ds.graphs;

/**
 * Minimum cost spanning tree
 * It is similar to prim's algorithm. It also uses greedy approach.
 * 1) Remove loops and parallel edges.(keep minimum weight)
 * 2) List all edges and sort them according to weight
 * 3) Select n-1 edges from the sorted list(But there should not be a cycle)
 * If it forms a cycle discard it.
 * It has to select minimum weight edge that would be minimum using the
 * heap/priority queue O(logn)
 */
public class KruskalAlgorithm {
}
