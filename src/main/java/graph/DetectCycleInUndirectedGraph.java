package graph;

import graph.Graph.Vertex;

import java.util.List;

public class DetectCycleInUndirectedGraph {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("contains cycle : " + isCycle(g));
    }

    private static boolean[] visited;

    private static boolean isCycle(Graph g) {

        int v = g.getAllVertices().size();
        visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (isCycleUtil(g, i, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCycleUtil(Graph g, int parent, int v) {
        visited[v] = true;
        List<Vertex> adjVertices = g.getAllAdjacentVertices(v);
        for (Vertex adj : adjVertices) {
            if (adj.id != parent) {
                if (visited[adj.id] == true) {
                    return true;
                }

                isCycleUtil(g, v, adj.id);
            }
        }

        return false;
    }
}
