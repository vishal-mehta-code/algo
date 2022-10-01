package graph;

import graph.Graph.Edge;

public class Clone {

	public static void main(String[] args) {
		Graph g = new Graph(true);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("printing orignal graph");
		BFS.bfs(g);

		Graph clone = clone(g);

		System.out.println("printing cloned graph");
		BFS.bfs(clone);
	}

	private static Graph clone(Graph g) {
		Graph clone = new Graph(g.isDirected);

		for (Edge edge : g.getAllEdges()) {
			clone.addEdge(edge.vertex1.id, edge.vertex2.id);
		}

		return clone;
	}
}
