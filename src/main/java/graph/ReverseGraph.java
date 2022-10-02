package graph;

import graph.Graph.Edge;

public class ReverseGraph {

    public static void main(String[] args) {
        Graph g = new Graph(true);
        g.addEdge(0, 1);
        g.addEdge(2, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("printing orignal graph");
        BFS.bfs(g);

        Graph reversedGraph = reverseGraph(g);

        System.out.println("printing reversed graph");
        BFS.bfs(reversedGraph);

    }

    private static Graph reverseGraph(Graph g) {
        Graph reversedGraph = new Graph(g.isDirected);
        for (Edge edge : g.getAllEdges()) {
            reversedGraph.addEdge(edge.vertex2.id, edge.vertex1.id);
        }

        return reversedGraph;
    }
}
