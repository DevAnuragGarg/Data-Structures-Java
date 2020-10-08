package com.anudev.ds.graphs.cycleundirected;

import com.anudev.ds.graphs.DisjointSets;

import java.util.ArrayList;

/**
 * Find cycle in undirected graph using disjoint sets. you can use the
 * DFS to find the cycle too.
 */
public class CycleUsingDisjointSets {

    private final int vertexCount;
    private final DisjointSets disjointSets;
    private final ArrayList<Edge> edgeArrayList;

    public CycleUsingDisjointSets(int numberOfVertices) {
        vertexCount = numberOfVertices;
        disjointSets = new DisjointSets();
        edgeArrayList = new ArrayList<>();
    }

    public void addEdge(int startIndex, int endIndex) {
        edgeArrayList.add(new Edge(startIndex, endIndex));
    }

    public boolean hasCycle() {
        // create the sets for all the vertices
        for (int i = 0; i < vertexCount; i++) {
            disjointSets.makeSet(i);
        }

        // for all the edges check if the parents of both the sides are same
        // we are using the edges having indexes not vertexes as we have
        // made the disjoint sets using the long value. not generalizing it.
        for (Edge edge : edgeArrayList) {
            long startingIndexParent = disjointSets.findSet(edge.getStartIndex());
            long endingIndexParent = disjointSets.findSet(edge.getEndIndex());

            // if the parents of both the vertex are same then means
            // cycle is present
            if (startingIndexParent == endingIndexParent) {
                return true;
            }
            disjointSets.union(edge.getStartIndex(), edge.getEndIndex());
        }
        return false;
    }
}
