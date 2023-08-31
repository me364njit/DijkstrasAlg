package com.example.graph;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create vertices
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);
        Graph.Vertex<Integer> v4 = new Graph.Vertex<>(4);
        Graph.Vertex<Integer> v5 = new Graph.Vertex<>(5);

        // Create edges
        Graph.Edge<Integer> e1 = new Graph.Edge<>(10, v1, v2);
        Graph.Edge<Integer> e2 = new Graph.Edge<>(5, v2, v3);
        Graph.Edge<Integer> e3 = new Graph.Edge<>(7, v1, v3);
        Graph.Edge<Integer> e4 = new Graph.Edge<>(12, v2, v4);
        Graph.Edge<Integer> e5 = new Graph.Edge<>(9, v3, v5);
        Graph.Edge<Integer> e6 = new Graph.Edge<>(6, v4, v5);

        // Add edges to vertices
        v1.addEdge(e1);
        v1.addEdge(e3);
        v2.addEdge(e1);
        v2.addEdge(e2);
        v2.addEdge(e4);
        v3.addEdge(e2);
        v3.addEdge(e3);
        v3.addEdge(e5);
        v4.addEdge(e4);
        v4.addEdge(e6);
        v5.addEdge(e5);
        v5.addEdge(e6);

        // Create a graph with vertices and edges
        List<Graph.Vertex<Integer>> vertices = new ArrayList<>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);

        List<Graph.Edge<Integer>> edges = new ArrayList<>();
        edges.add(e1);
        edges.add(e2);
        edges.add(e3);
        edges.add(e4);
        edges.add(e5);
        edges.add(e6);

        Graph<Integer> graph = new Graph<>(vertices, edges);

        // Define start and end vertices for testing
        Graph.Vertex<Integer> startVertex = v1;
        Graph.Vertex<Integer> endVertex = v5;

        System.out.println("Vertices:");
        for (Graph.Vertex<Integer> vertex : graph.getVertices()) {
            System.out.println("Vertex " + vertex.getValue());
            System.out.println("Edges:");
            for (Graph.Edge<Integer> edge : vertex.getEdges()) {
                System.out.println("  " + edge.getFromVertex().getValue() + " -> " +
                                   edge.getToVertex().getValue() + ", Cost: " + edge.getCost());
            }
            System.out.println();
        }


        // Calculate shortest path using Dijkstra's algorithm
       //DijkstrasAlg shortestPathFinder = new DijkstrasAlg();
        Graph.CostPathPair<Integer> shortestPath = DijkstrasAlg.getShortestPath(graph, startVertex, endVertex);

        if (shortestPath != null) {
            System.out.println("Shortest Path Cost: " + shortestPath.getCost());
            List<Graph.Edge<Integer>> pathEdges = shortestPath.getPath();
            System.out.print("Shortest Path: ");
            for (Graph.Edge<Integer> edge : pathEdges) {
                System.out.print(edge.getFromVertex().getValue() + " -> ");
            }
            System.out.println(endVertex.getValue());
        } else {
            System.out.println("No path found.");
        }
    }
}
