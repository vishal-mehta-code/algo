package graph;

import graph.Graph.Vertex;

import java.util.List;
import java.util.Stack;

public class TopologicalSorting {

	public static void main(String[] args) {

		Graph g = new Graph(true);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);

		topologicalSort(g);
	}

	private static boolean[] visited;
	private static Stack<Integer> stk = new Stack<>();

	public static void topologicalSort(Graph g) {

		int v = g.getAllVertices().size();
		visited = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				topologicalSortUtil(g, i);
			}
		}

		while (!stk.isEmpty()) {
			System.out.println(stk.pop());
		}

	}

	private static void topologicalSortUtil(Graph g, int v) {
		visited[v] = true;

		List<Vertex> list = g.getAllAdjacentVertices(v);

		for (Vertex n : list) {
			if (!visited[n.id])
				topologicalSortUtil(g, n.id);
		}

		stk.push(v);
	}

}
