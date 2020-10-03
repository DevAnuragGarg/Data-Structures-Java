package com.anudev.ds.graphs;

public class Vertex {
    private final char label;
    private boolean isVisited;

    public Vertex(char lab) {
        label = lab;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        System.out.print(label + ", ");
        isVisited = visited;
    }
}
