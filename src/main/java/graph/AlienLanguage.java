package graph;

import graph.Graph.Vertex;

import java.util.List;
import java.util.Stack;

public class AlienLanguage {

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        interpretOrder(words);
    }

    private static void interpretOrder(String[] words) {
        Graph graph = new Graph(true);

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int k = Math.min(word1.length(), word2.length());

            for (int j = 0; j < k; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.addEdge(word1.substring(j, j + 1), word2.substring(j, j + 1));
                    break;
                }
            }
        }

        topogicalSorting(graph);
    }

    private static boolean[] visited;
    private static Stack<String> stk = new Stack<>();

    private static void topogicalSorting(Graph graph) {
        int v = graph.getAllVertices().size();

        visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i])
                topogicalSortingUtil(graph, i);
        }

        while (!stk.isEmpty()) {
            System.out.println("printing " + stk.pop());
        }

    }

    private static void topogicalSortingUtil(Graph graph, int v) {
        visited[v] = true;
        List<Vertex> vertices = graph.getAllAdjacentVertices(v);
        for (Vertex n : vertices) {
            if (!visited[n.id]) {
                topogicalSortingUtil(graph, n.id);
            }
        }

        stk.push(graph.getVertex(v).data);
    }
}
