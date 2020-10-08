package com.anudev.ds.graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * Disjoint sets is a data structure that uses three operations:
 * makeSet, union and findSet. makeSet is an operation to create a set
 * with only 1 element in there. Union is an operation to take two
 * different sets and merge them into 1 set. findSet is an operation to
 * return an identity of a set which is usually an element in a set which
 * acts as a representative of that set. use cases: Kruskal's algorithm,
 * finding cycle in an undirected graph. Most popular implementation of
 * disjoint sets is the one which uses "union by rank and path compression"
 * to run this operations efficiently.
 * <p>
 * We are going to represent out disjoint sets using tree. every node of
 * the tree will have three properties: rank, data and parent. Rank is
 * going to store approx. depth of the tree, data is going to store the
 * actual data elements and parent is the pointer from child to parent.
 * <p>
 * Union by rank means while joining the elements set the rank of the
 * new set as the higher rank between two.
 * <p>
 * Time complexity: m operations and n elements
 * O(m alpha(n)) = O(4m) as alpha(n) is always <= 4.
 * so it becomes O(m)
 */
public class DisjointSets {

    private Map<Long, Node> map = new HashMap<>();

    /**
     * create the set using only one element
     */
    public void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    /**
     * combines two sets together to one, does union by rank
     */
    public void union(long data1, long data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        // same parent return, means of same set
        if (parent1 == parent2) {
            return;
        }

        if (parent1.rank >= parent2.rank) {
            parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1
                    : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
    }

    /**
     * find the representative of the set
     */
    public long findSet(long data) {
        return findSet(map.get(data)).data;
    }

    /**
     * find the representative recursively and does the path
     * compression as well
     */
    public Node findSet(Node node) {
        Node parent = node.parent;
        if(parent == node){
            return node;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    class Node {
        long data;
        Node parent;
        int rank;
    }
}
