package graph;

import java.util.*;
import java.util.Map.Entry;

public class Graph {

    private List<Edge> allEdges = new ArrayList<>();
    private Map<Integer, Vertex> vertexIdMap = new HashMap<>();
    boolean isDirected;

    public Graph() {
    }

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public void addEdge(int id1, int id2) {
        Vertex vertex1 = null;
        if (null != vertexIdMap.get(id1)) {
            vertex1 = vertexIdMap.get(id1);
        } else {
            vertex1 = new Vertex(id1);
            vertexIdMap.put(id1, vertex1);
        }

        Vertex vertex2 = null;
        if (null != vertexIdMap.get(id2)) {
            vertex2 = vertexIdMap.get(id2);
        } else {
            vertex2 = new Vertex(id2);
            vertexIdMap.put(id2, vertex2);
        }

        Edge edge = new Edge(vertex1, vertex2);
        allEdges.add(edge);

        vertex1.adjacentVertices.add(vertex2);
        if (!isDirected) {
            vertex2.adjacentVertices.add(vertex1);
        }

    }

    Map<String, Integer> dataToIdMap = new HashMap<>();
    int id = 0;

    public void addEdge(String data1, String data2) {
        Vertex vertex1 = null;
        if (null != vertexIdMap.get(dataToIdMap.get(data1))) {
            vertex1 = vertexIdMap.get(dataToIdMap.get(data1));
        } else {
            vertex1 = new Vertex(id, data1);
            vertexIdMap.put(id, vertex1);
            dataToIdMap.put(data1, id);
            id++;
        }

        Vertex vertex2 = null;
        if (null != vertexIdMap.get(dataToIdMap.get(data2))) {
            vertex2 = vertexIdMap.get(dataToIdMap.get(data2));
        } else {
            vertex2 = new Vertex(id, data2);
            vertexIdMap.put(id, vertex2);
            dataToIdMap.put(data2, id);
            id++;
        }

        Edge edge = new Edge(vertex1, vertex2);
        allEdges.add(edge);

        vertex1.adjacentVertices.add(vertex2);

        if (!isDirected) {
            vertex2.adjacentVertices.add(vertex1);
        }

    }

    public List<Edge> getAllEdges() {
        return allEdges;
    }

    public List<Vertex> getAllVertices() {
        List<Vertex> vertices = new ArrayList<>();
        Set<Entry<Integer, Vertex>> entrySet = vertexIdMap.entrySet();
        for (Entry<Integer, Vertex> entry : entrySet) {
            vertices.add(entry.getValue());
        }
        return vertices;
    }

    public List<Vertex> getAllAdjacentVertices(int id) {
        return vertexIdMap.get(id).adjacentVertices;
    }

    public Vertex getVertex(int id) {
        return vertexIdMap.get(id);
    }

    public static class Vertex {
        public int id;
        public String data;
        public List<Vertex> adjacentVertices = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public Vertex(int id, String data) {
            this.id = id;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Vertex [id=" + id + ", data=" + data + "]";
        }

    }

    public class Edge {
        public Vertex vertex1;
        public Vertex vertex2;

        public Edge(Vertex vertex1, Vertex vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

    }

}
