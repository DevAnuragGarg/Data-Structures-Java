package com.anudev.ds.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph: is a pair(V,E), where V is a set of nodes, called vertices and
 * E is a collection of pairs of vertices called edges. There can be
 * directed graph and undirected graphs. Degree of vertex is number of
 * edges incident on it. Applications: 1) Representing relationships
 * between components and electronic circuits. 2) Transportation networks
 * 3) Computer networks 4) Databases: representing dependencies in tables
 * <p>
 * Graph can be represented in Adjacency matrix and Adjacency List.
 * <p>
 * 1) In adjacency matrix the edge is denoted using the 2 D matrix
 * In case of Dense graphs you must use matrix
 * <p>
 * 2) In Adjacency list: all the vertices connected to vertex v are
 * listed on an adjacency list for that vertex v. If the graph is sparse
 * you should use list
 */

public class Graph {
    private final int vertexCount;

    // using adjacency matrix
    private final int[][] adjMatrix;

    // using list
    private final List<List<Integer>> adjList;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjMatrix = new int[vertexCount][vertexCount];

        adjList = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && j >= 0 && i < vertexCount && j < vertexCount) {
            // adjacency matrix
            adjMatrix[i][j] = 1;
            adjMatrix[j][i] = 1;

            // adjacency list
            adjList.get(i).add(j);
            adjList.get(j).add(i);
        }
    }

    public void removeEdge(int i, int j) {
        if (i >= 0 && j >= 0 && i < vertexCount && j < vertexCount) {
            // adjacency matrix
            adjMatrix[i][j] = 0;
            adjMatrix[j][i] = 0;

            // adjacency list
            adjList.get(i).remove(j);
            adjList.get(j).remove(i);
        }
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && j >= 0 && i < vertexCount && j < vertexCount) {
            return adjMatrix[i][j] == 1;
        }
        return false;
    }

    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix");
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printAdjacencyList() {
        System.out.println("Adjacency List");
        for (int i = 0; i < vertexCount; i++) {
            List<Integer> list = adjList.get(i);
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
