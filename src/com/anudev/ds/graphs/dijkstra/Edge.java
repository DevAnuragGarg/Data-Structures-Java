package com.anudev.ds.graphs.dijkstra;

public class Edge {
    private final Vertex endVertex;
    private final Vertex startVertex;

    private int weightedDistance;

    public Edge(Vertex startingVertex, Vertex endingVertex, int dis) {
        weightedDistance = dis;
        endVertex = endingVertex;
        startVertex = startingVertex;
    }

    public int getWeightedDistance() {
        return weightedDistance;
    }

    public void setWeightedDistance(int weightedDistance) {
        this.weightedDistance = weightedDistance;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }
}
