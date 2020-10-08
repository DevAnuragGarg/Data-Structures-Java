package com.anudev.ds.graphs.cycledirected;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * this can be solved using the DFS. Here we keep three sets: white, grey
 * and black set. In white set we keep the vertex which has not visited.
 * Grey set contains the vertices which are being visited and black set
 * contains the vertices which are already visited including their children
 * <p>
 * If the vertex while traversing found to be again in the grey area than
 * there is cycle otherwise not.
 */
public class CycleUsingDFS {

    public final Vertex[] vertices;
    private Set<Vertex> greySet = new HashSet<>();
    private Set<Vertex> whiteSet = new HashSet<>();
    private Set<Vertex> blackSet = new HashSet<>();

    private int vertexCount;

    public CycleUsingDFS(int numberOfVertices) {
        vertices = new Vertex[numberOfVertices];
    }

    public void addVertex(char label) {
        vertices[vertexCount++] = new Vertex(label);
    }

    public boolean hasCycle() {
        whiteSet.addAll(Arrays.asList(vertices));

        // check if the white set is empty or not
        if (whiteSet.isEmpty()) {
            return false;
        }

        while (whiteSet.size() > 0) {
            Vertex current = whiteSet.iterator().next();
            if (dfs(current)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(Vertex currentVertex) {
        // move from
        moveVertex(currentVertex, whiteSet, greySet);

        // get all the edges from that vertex
        for (Edge edge : currentVertex.getEdges()) {
            Vertex neighbourVertex = edge.getEndVertex();

            // if the neighbour vertex is found in black set then it
            // is already being traversed. so no need to do anything
            // just continue with other neighbouring vertices
            if (blackSet.contains(neighbourVertex)) {
                continue;
            }

            // if the neighbouring vertex is found in grey vertex then
            // there is a cycle no need to continue just return the value
            if (greySet.contains(neighbourVertex)) {
                return true;
            }

            // do the same for the neighbouring vertex as we do in dfs
            if (dfs(neighbourVertex)) {
                return true;
            }
        }
        // move from grey to black
        moveVertex(currentVertex, greySet, blackSet);
        return false;
    }

    private void moveVertex(Vertex vertex, Set<Vertex> fromSet, Set<Vertex> toSet) {
        fromSet.remove(vertex);
        toSet.add(vertex);
    }

    public Vertex getVertex(int position) {
        return vertices[position];
    }
}
