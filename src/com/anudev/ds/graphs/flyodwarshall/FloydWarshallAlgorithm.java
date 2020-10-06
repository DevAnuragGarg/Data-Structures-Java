package com.anudev.ds.graphs.flyodwarshall;

/**
 * if you need to find the shortest path between any two vertices. Floyd
 * warshall is also called all pairs shortest path algo. We can find the
 * shortest distance from one vertex to all the other vertices using
 * dijkstra algorithm. It takes O(n2) for one vertex, but for all the
 * vertex it would be O(n3). But it is a greedy algorithm, in place Floyd
 * Warshall algorithm uses dynamic programming approach. Application of
 * Floyd Warshall algorithm are clean's algorithm or transitive closure
 * or widest path
 * <p>
 * For n number times i.e. number of vertices, we create the 2D matrix
 * keeping value k varies from 0 to n-1. We use the formula
 * if(d[i][j] > d[i][k] + d[k][j]) update d[i][j] = d[i][k] + d[k][j]
 */
public class FloydWarshallAlgorithm {

    private final Vertex[] vertices;
    private int vertexCount;
    private int[][] weightEdges;

    public FloydWarshallAlgorithm(int numberOfVertices) {
        vertices = new Vertex[numberOfVertices];
        weightEdges = new int[numberOfVertices][numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {

            for (int j = 0; j < numberOfVertices; j++) {

                if (i == j) {
                    weightEdges[i][j] = 0;
                } else {
                    weightEdges[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void addVertex(char label) {
        vertices[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int startingVertex, int endVertex, int weight) {
        weightEdges[startingVertex][endVertex] = weight;
    }

    public void performAlgo() {

        // number of times matrix has to be formed
        // lets assume kth vertex is between ith and jth vertex
        for (int k = 0; k < vertexCount; k++) {
            int[][] newMatrix = new int[vertexCount][vertexCount];

            // going through the old matrix and putting values
            // in new matrix
            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {

                    if (weightEdges[i][k] != Integer.MAX_VALUE
                            && weightEdges[k][j] != Integer.MAX_VALUE
                            && weightEdges[i][k] + weightEdges[k][j] < weightEdges[i][j]) {
                        newMatrix[i][j] = weightEdges[i][k] + weightEdges[k][j];
                    } else {
                        newMatrix[i][j] = weightEdges[i][j];
                    }
                }
            }
            weightEdges = newMatrix;
        }

        // print all the values
        for (int i = 0; i < vertexCount; i++) {

            for (int j = 0; j < vertexCount; j++) {

                if (i != j) {
                    System.out.println("Distance from " + vertices[i].getLabel()
                            + " to " + vertices[j].getLabel() + " is "
                            + weightEdges[i][j]);
                }
            }
        }
    }
}
