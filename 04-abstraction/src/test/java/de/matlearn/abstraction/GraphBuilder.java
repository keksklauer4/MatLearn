package de.matlearn.abstraction;

import de.matlearn.abstraction.graph.GenericVertex;
import de.matlearn.abstraction.graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphBuilder {
    private final Graph<GenericVertex> graph;
    private final List<GenericVertex> vertices;

    public GraphBuilder() {
        this.graph = new Graph<>();
        vertices = new ArrayList<>();
    }

    public Graph<GenericVertex> getGraph() {
        return graph;
    }

    public List<GenericVertex> getVertices() {
        return vertices;
    }

    public void addVertices(int numberToAdd){
        for (int i = 0; i < numberToAdd; i++) {
            GenericVertex vertex = new GenericVertex();
            graph.registerVertex(vertex);
            vertices.add(vertex);
        }
    }

    public void addEdges(Map<Integer, Integer> edgeIndices){
        edgeIndices.forEach((key, value) ->
                graph.addEdge(vertices.get(key), vertices.get(value)));
    }
}
