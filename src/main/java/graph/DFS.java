package graph;

import graph.Graph.Vertex;

import java.util.List;

public class DFS {

    private static boolean[] visited;

    public static void main(String[] args) {

        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        dfs(g);
    }

    public static void dfs(Graph g) {
        int v = g.getAllVertices().size();
        visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfsUtil(g, i);
            }
        }
    }

    private static void dfsUtil(Graph g, int v) {
        visited[v] = true;
        System.out.println(v);
        List<Vertex> list = g.getAllAdjacentVertices(v);

        for (Vertex vertex : list) {
            if (!visited[vertex.id]) {
                dfsUtil(g, vertex.id);
            }
        }
    }
}
