package com.anudev.ds.graphs;

import com.anudev.ds.graphs.bellmanford.BellmanFordAlgorithm;
import com.anudev.ds.graphs.cycledirected.CycleUsingDFS;
import com.anudev.ds.graphs.cycleundirected.CycleUsingDisjointSets;
import com.anudev.ds.graphs.dijkstra.DijkstraAlgorithm;
import com.anudev.ds.graphs.dijkstra.Edge;
import com.anudev.ds.graphs.dijkstra.Vertex;
import com.anudev.ds.graphs.floydwarshall.FloydWarshallAlgorithm;

public class GraphMainProgram {

    public static void main(String[] args) {

        //=======================================
        // Graph with adjacency matrix and lists
        //=======================================
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printAdjacencyMatrix();
        System.out.println();
        graph.printAdjacencyList();
        System.out.println();

        //======
        // DFS
        //======
        System.out.println("DFS");
        DFS dfs = new DFS(4);
        dfs.addVertex('A');
        dfs.addVertex('B');
        dfs.addVertex('C');
        dfs.addVertex('D');
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);
        dfs.performDFS(0);
        System.out.println("\n");

        //=======
        // BFS
        //=======
        System.out.println("BFS");
        BFS bfs = new BFS(7);
        bfs.addVertex('A');
        bfs.addVertex('B');
        bfs.addVertex('C');
        bfs.addVertex('D');
        bfs.addVertex('E');
        bfs.addVertex('F');
        bfs.addVertex('G');
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 6);
        bfs.addEdge(1, 3);
        bfs.addEdge(1, 4);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 4);
        bfs.addEdge(3, 6);
        bfs.addEdge(4, 6);
        bfs.addEdge(5, 6);
        bfs.performBFS(0);
        System.out.println("\n");

        //===========
        // Dijkstra
        //===========
        System.out.println("Dijkstra");
        // creating vertices
        Vertex vertex1 = new Vertex('A');
        Vertex vertex2 = new Vertex('B');
        Vertex vertex3 = new Vertex('C');
        Vertex vertex4 = new Vertex('D');
        Vertex vertex5 = new Vertex('E');
        Vertex vertex6 = new Vertex('F');
        // creating edges : We are using this so that we no need to
        // create the adjacency matrix or list. Just directly adding
        // the edges into the vertex from which the edge starts
        Edge edge1 = new Edge(vertex1, vertex2, 10);
        Edge edge2 = new Edge(vertex1, vertex3, 15);
        Edge edge3 = new Edge(vertex2, vertex4, 12);
        Edge edge4 = new Edge(vertex2, vertex6, 15);
        Edge edge5 = new Edge(vertex4, vertex6, 1);
        Edge edge6 = new Edge(vertex3, vertex5, 10);
        Edge edge7 = new Edge(vertex4, vertex5, 2);
        Edge edge8 = new Edge(vertex6, vertex5, 5);
        // adding edges to vertices
        vertex1.addEdge(edge1);
        vertex1.addEdge(edge2);
        vertex2.addEdge(edge3);
        vertex2.addEdge(edge4);
        vertex3.addEdge(edge6);
        vertex4.addEdge(edge5);
        vertex4.addEdge(edge7);
        vertex6.addEdge(edge8);
        // performing algo
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        dijkstra.performDijkstraAlgorithm(vertex1);
        System.out.println("Distance of " + vertex2.getLabel() + " is " + vertex2.getMinDistance());
        System.out.println("Distance of " + vertex3.getLabel() + " is " + vertex3.getMinDistance());
        System.out.println("Distance of " + vertex4.getLabel() + " is " + vertex4.getMinDistance());
        System.out.println("Distance of " + vertex5.getLabel() + " is " + vertex5.getMinDistance());
        System.out.println("Distance of " + vertex6.getLabel() + " is " + vertex6.getMinDistance());
        System.out.println();

        //====================
        // Bellman ford algo
        //====================
        BellmanFordAlgorithm algorithm = new BellmanFordAlgorithm(6);
        // creating vertices
        algorithm.addVertex('A');
        algorithm.addVertex('B');
        algorithm.addVertex('C');
        algorithm.addVertex('D');
        algorithm.addVertex('E');
        algorithm.addVertex('F');
        // creating edges
        algorithm.addEdge(0, 1, 10);
        algorithm.addEdge(0, 2, 15);
        algorithm.addEdge(1, 3, 12);
        algorithm.addEdge(1, 5, 15);
        algorithm.addEdge(3, 5, 1);
        algorithm.addEdge(2, 4, 10);
        algorithm.addEdge(3, 4, 2);
        algorithm.addEdge(5, 4, 5);
        // performing algo
        algorithm.performAlgo(0);

        //====================
        // Floyd warshall algo
        //====================
        System.out.println("\nFloyd Warshall Algorithm");
        FloydWarshallAlgorithm algo = new FloydWarshallAlgorithm(4);
        // creating vertices
        algo.addVertex('A');
        algo.addVertex('B');
        algo.addVertex('C');
        algo.addVertex('D');
        // creating edges
        algo.addEdge(0, 1, 3);
        algo.addEdge(1, 2, -2);
        algo.addEdge(2, 3, 2);
        algo.addEdge(3, 0, 1);
        algo.addEdge(0, 3, 15);
        algo.addEdge(0, 2, 6);
        // performing algo
        algo.performAlgo();

        //====================
        // Disjoint sets
        //====================
        System.out.println("\nDisjoint sets");
        DisjointSets disjointSets = new DisjointSets();
        disjointSets.makeSet(1);
        disjointSets.makeSet(2);
        disjointSets.makeSet(3);
        disjointSets.makeSet(4);
        disjointSets.makeSet(5);
        disjointSets.makeSet(6);
        disjointSets.makeSet(7);

        // do unions
        disjointSets.union(1, 2);
        disjointSets.union(2, 3);
        disjointSets.union(4, 5);
        disjointSets.union(6, 7);
        disjointSets.union(5, 6);
        disjointSets.union(3, 7);

        // find set
        System.out.println(disjointSets.findSet(1));
        System.out.println(disjointSets.findSet(2));
        System.out.println(disjointSets.findSet(3));
        System.out.println(disjointSets.findSet(4));
        System.out.println(disjointSets.findSet(5));
        System.out.println(disjointSets.findSet(6));
        System.out.println(disjointSets.findSet(7));

        //=======================================================
        // finding cycle in undirected graph using disjoint sets
        //=======================================================
        System.out.println("\nCycle in undirected graph using Disjoint sets");
        CycleUsingDisjointSets cycleUsingDisjointSets = new CycleUsingDisjointSets(4);
        cycleUsingDisjointSets.addEdge(0, 1);
        cycleUsingDisjointSets.addEdge(1, 2);
        cycleUsingDisjointSets.addEdge(2, 0);
        cycleUsingDisjointSets.addEdge(2, 3);
        System.out.println("Does this graph has cycle: " + cycleUsingDisjointSets.hasCycle());

        //===========================================
        // finding cycle in directed graph using dfs
        //===========================================
        System.out.println("\nCycle in directed graph using DFS");
        CycleUsingDFS cycleUsingDFS = new CycleUsingDFS(6);
        cycleUsingDFS.addVertex('1');
        cycleUsingDFS.addVertex('2');
        cycleUsingDFS.addVertex('3');
        cycleUsingDFS.addVertex('4');
        cycleUsingDFS.addVertex('5');
        cycleUsingDFS.addVertex('6');

        // add edges
        cycleUsingDFS.getVertex(0).addEdge(cycleUsingDFS.getVertex(1));
        cycleUsingDFS.getVertex(3).addEdge(cycleUsingDFS.getVertex(0));
        cycleUsingDFS.getVertex(3).addEdge(cycleUsingDFS.getVertex(4));
        cycleUsingDFS.getVertex(4).addEdge(cycleUsingDFS.getVertex(5));
        cycleUsingDFS.getVertex(5).addEdge(cycleUsingDFS.getVertex(3));

        // run algo
        System.out.println("Does this graph has cycle: " + cycleUsingDFS.hasCycle());
    }
}
