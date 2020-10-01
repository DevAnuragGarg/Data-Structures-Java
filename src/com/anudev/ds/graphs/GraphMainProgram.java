package com.anudev.ds.graphs;

public class GraphMainProgram {

    public static void main(String[] args) {

        // Graph with adjacency matrix and lists
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

        // DFS
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
        dfs.performDFS(2);

        // BFS
    }
}
