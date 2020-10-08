package com.anudev.ds.graphs.cycleundirected;

public class Edge {
    private final int endIndex;
    private final int startVertex;

    public Edge(int startingIndex, int endingIndex) {
        endIndex = startingIndex;
        startVertex = endingIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getStartIndex() {
        return startVertex;
    }
}
