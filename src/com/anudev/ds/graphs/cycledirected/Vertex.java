package com.anudev.ds.graphs.cycledirected;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private final char label;
    private final List<Edge> edges;

    private Vertex previousVertex;

    private int minDistance = Integer.MAX_VALUE;

    public Vertex(char label) {
        this.label = label;
        edges = new ArrayList<>();
    }

    public void addEdge(Vertex endVertex) {
        edges.add(new Edge(this, endVertex));
    }

    public List<Edge> getEdges() {
        return edges;
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
