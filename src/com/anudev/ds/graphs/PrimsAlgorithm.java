package com.anudev.ds.graphs;

/**
 * This is used to find minimum spanning tree in undirected graph.
 * This algorithm is greedy algorithm
 * <p>
 * 1) Remove all the loops(start and end same index)
 * 2) Remove parallel edges(if both the edges start from same vertex and
 * end at same vertex but weight different) then take minimum weight edge
 * 3) Choose any vertex at root node. Check outgoing edges from that node
 * and choose the edge with minimum weight.
 * 4) Now after selecting that edge. Now check through all the edges going
 * from those two vertices and select the edge with minimum weight And
 * keep on repeating it. Remember not to have any cycle formation.
 * <p>
 * Spanning tree: is a subgraph having all the vertices and edges = v-1
 * basically not having any cycle in the graph.
 * <p>
 * Minimum spanning tree of a weighted undirected subgraph such that the
 * sum of the edges is minimum.
 */
public class PrimsAlgorithm {
}
