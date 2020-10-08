package com.anudev.ds.graphs.cycledirected;

public class Edge {
    private final Vertex endVertex;
    private final Vertex startVertex;

    public Edge(Vertex startingVertex, Vertex endingVertex) {
        endVertex = endingVertex;
        startVertex = startingVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }
}
