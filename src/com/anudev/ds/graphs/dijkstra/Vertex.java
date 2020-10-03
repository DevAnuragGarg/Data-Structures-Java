package com.anudev.ds.graphs.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    private final char label;
    private final List<Edge> edges;

    private Vertex previousVertex;

    private int minDistance = Integer.MAX_VALUE;

    public Vertex(char label) {
        this.label = label;
        edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public int compareTo(Vertex o) {
        return minDistance - o.minDistance;
    }

    public char getLabel() {
        return label;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }
}
