package graph;

import graph.Graph.Vertex;

public class DetectCycleInDirectedGraph {

    public static void main(String[] args) {
        Graph g = new Graph(true);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("contains cycle : " + isCycle(g));
    }

    private static boolean[] visited;
    private static boolean[] currVisited;

    private static boolean isCycle(Graph g) {
        int v = g.getAllVertices().size();
        visited = new boolean[v];
        currVisited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (isCyclUtil(g, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclUtil(Graph g, int v) {
        visited[v] = true;
        currVisited[v] = true;

        for (Vertex adj : g.getAllAdjacentVertices(v)) {
            if (visited[adj.id] && currVisited[adj.id]) {
                return true;
            }
            return isCyclUtil(g, adj.id);
        }

        currVisited[v] = false;
        return false;
    }
}
