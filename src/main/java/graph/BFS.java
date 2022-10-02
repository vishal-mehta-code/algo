package graph;

import graph.Graph.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        Graph g = new Graph(true);
        g.addEdge(0, 1);
        g.addEdge(2, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("printing graph");
        bfs(g);
    }

    private static boolean[] visited;

    public static void bfs(Graph g) {
        int v = g.getAllVertices().size();
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                bfsUtil(g, i);
            }
        }
    }

    private static void bfsUtil(Graph g, int i) {
        Queue<Integer> queue = new LinkedList<>();

        visited[i] = true;
        queue.add(i);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            System.out.println(current);

            List<Vertex> adj = g.getAllAdjacentVertices(current);

            for (Vertex adjVertex : adj) {
                if (!visited[adjVertex.id]) {
                    visited[adjVertex.id] = true;
                    queue.add(adjVertex.id);
                }
            }
        }
    }
}
