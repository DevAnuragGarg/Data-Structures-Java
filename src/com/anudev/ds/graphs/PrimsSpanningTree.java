package com.anudev.ds.graphs;

/**
 * A graph which contains all vertices with minimum number of edges.
 * It can be said as spanning subgraph and spanning tree. We should not
 * take that edge that makes the cycle in the graph. If the weights are
 * given find the spanning tree with minimum sum of weights.
 * <p>
 * Prim's algorithm: 1) Remove loops and parallel edges(keep minimum weight)
 * 2) while adding new edge, select edge with minimum weight out of the
 * edges from already visited vertices(no cycle allowed) 3) stop at n-1
 * edges. Number of edges for min spanning tree is n-1 where n is vertices
 *
 * This is a greedy algorithm: Spanning tree is subgraph of a graph such
 * that all n vertices are connected to each other and there are total
 * n-1 edges in the subgraph.
 */
public class PrimsSpanningTree {

}
