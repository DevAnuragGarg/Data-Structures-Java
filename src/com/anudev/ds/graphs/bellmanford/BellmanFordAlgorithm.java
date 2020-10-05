package com.anudev.ds.graphs.bellmanford;

import java.util.ArrayList;

/**
 * Bellman algorithm single source shortest distance
 * THis follows dynamic programming strategy. Find all the solution and
 * pickup the best possible solution. It says about relaxing all the
 * edges and each edge for V-1 times where V is number of vertices in graph.
 * This algo takes longer time then dijkstra.
 * Time complexity = O(|E|*|v-1|) ~ O(n2)
 * In case of complete graph number of edges will be n(n-1)/2, so time
 * complexity will become ~ O(n3)
 * Disadvantage: if there is cycle of with total weight of cycle is negative
 * then graph cannot be solved as it keep on decrementing the value in each
 * iteration
 * So you can find negative weight cycles in the graph.
 */
public class BellmanFordAlgorithm {

    private int vertexCount;
    private Vertex[] vertices;
    private ArrayList<Edge> edges;

    public BellmanFordAlgorithm(int numberOfVertices) {
        edges = new ArrayList<>();
        vertices = new Vertex[numberOfVertices];
    }

    public void addVertex(char label) {
        vertices[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int i, int j, int weight) {
        edges.add(new Edge(vertices[i], vertices[j], weight));
    }

    public void performAlgo(int startingVertex) {
        System.out.println("Bellman Algorithm");
        vertices[startingVertex].setMinDistance(0);

        // number of times relaxation done for whole graph is number
        // of vertices - 1
        for (int i = 0; i < vertexCount - 1; i++) {

            // going through all the edges
            for (Edge edge : edges) {
                int actualDistanceFromSource = edge.getStartVertex().getMinDistance() + edge.getWeightedDistance();

                // if the actual distance is less than distance from end vertex
                // then replace
                if (edge.getStartVertex().getMinDistance() != Integer.MAX_VALUE
                        && actualDistanceFromSource < edge.getEndVertex().getMinDistance()) {
                    edge.getEndVertex().setMinDistance(actualDistanceFromSource);
                    edge.getEndVertex().setPreviousVertex(edge.getStartVertex());
                }
            }
        }

        for (Vertex vertex : vertices) {
            System.out.println("Distance from " + vertices[startingVertex].getLabel()
                    + " to " + vertex.getLabel() + " is " + vertex.getMinDistance());
        }
    }
}
