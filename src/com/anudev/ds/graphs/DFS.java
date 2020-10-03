package com.anudev.ds.graphs;

import java.util.Stack;

/**
 * DFS works in manner similar to preorder traversal of trees. Internally
 * algorithm uses stacks. Need to take care of 2 things: 1) visiting a
 * vertex 2) Exploration of vertex
 */
public class DFS {

    private final Vertex[] vertices;
    private final int[][] adjMatrix;
    private final Stack<Integer> stack;

    private int vertexCount;

    public DFS(int numberOfVertices) {
        stack = new Stack<>();
        adjMatrix = new int[numberOfVertices][numberOfVertices];
        vertices = new Vertex[numberOfVertices];
    }

    public void addVertex(char lab) {
        vertices[vertexCount] = new Vertex(lab);
        vertexCount++;
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void performDFS(int value) {
        stack.push(value);
        vertices[value].setVisited(true);

        // keep pushing
        while (!stack.isEmpty()) {

            int v = getAdjUnvisitedMatrix(stack.peek());
            if (v != -1) {
                vertices[v].setVisited(true);
                stack.push(v);
            } else {
                stack.pop();
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