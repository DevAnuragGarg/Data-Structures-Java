package com.anudev.ds.graphs.dijkstra;

import java.util.PriorityQueue;

/**
 * This is one of the greedy algorithm. This is used for single source
 * shortest path. This is minimization problem which in turn is optimization
 * problem. Optimization problem can be used by greedy method. Greedy method
 * says problem should be solved in stages taking one input at a time.
 * <p>
 * Worst time complexity can be like = n(number of vertices) * n (relaxing
 * (relaxing means checking the shortest path) for n vertices)
 * <p>
 * For each vertex you check D[u] + D[U,V]. It may or may not work for
 * the negative lengths.
 **/
public class DijkstraAlgorithm {

    private PriorityQueue<Vertex> priorityQueue;

    public DijkstraAlgorithm() {
        priorityQueue = new PriorityQueue<>();
    }

    public void performDijkstraAlgorithm(Vertex v) {
        priorityQueue.add(v);
        v.setMinDistance(0);
        while (!priorityQueue.isEmpty()) {
            // dequeue the min distance vertex
            Vertex minDistanceVertex = priorityQueue.poll();

            // get all the edges attached to minDistanceVertex.

            for (Edge edge : minDistanceVertex.getEdges()) {

                // for all the neighbour vertices check the min distance
                if (minDistanceVertex.getMinDistance() + edge.getWeightedDistance() < edge.getEndVertex().getMinDistance()) {
                    edge.getEndVertex().setPreviousVertex(minDistanceVertex);
                    edge.getEndVertex().setMinDistance(minDistanceVertex.getMinDistance() + edge.getWeightedDistance());
                    priorityQueue.add(edge.getEndVertex());
                }
            }
        }
    }
}
