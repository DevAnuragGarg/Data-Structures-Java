package com.anudev.ds.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS is a traversing algorithm where you should start traversing from
 * a selected node (source or starting node) and traverse the graph layer
 * wise thus exploring the neighbour nodes (nodes which are directly
 * connected to source node). You must then move towards the next-level
 * neighbour nodes. First move horizontally and visit all the nodes of
 * the current layer. Move to the next layer
 */
public class BFS {
    private final int[][] adjMatrix;
    private final Vertex[] vertices;
    private final Queue<Integer> queue;

    private int vertexCount;

    public BFS(int numberOfVertices) {
        adjMatrix = new int[numberOfVertices][numberOfVertices];
        vertices = new Vertex[numberOfVertices];
        queue = new LinkedList<>();
    }

    public void addVertex(char label) {
        vertices[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void performBFS(int index) {
        queue.add(index);
        vertices[index].setVisited(true);
        while (!queue.isEmpty()) {
            int value = queue.poll();

            // add all the unvisited vertex to the queue
            int unvisitedVertex = getAdjUnvisitedMatrix(value);
            while (unvisitedVertex != -1) {
                queue.add(unvisitedVertex);
                vertices[unvisitedVertex].setVisited(true);
                unvisitedVertex = getAdjUnvisitedMatrix(value);
            }
        }
    }

    private int getAdjUnvisitedMatrix(int x) {
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[x][i] == 1 && !vertices[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }
}