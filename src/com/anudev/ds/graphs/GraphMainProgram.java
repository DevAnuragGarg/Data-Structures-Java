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
        dfs.performDFS(0);
        System.out.println("\n");

        // BFS
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
    }
}
