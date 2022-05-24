package main.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EdgeList<Vertex extends GenericVertex> implements Serializable {
    private HashMap<Vertex, List<Edge>> forwardEdges;
    private HashMap<Vertex, List<Edge>> backwardEdges;

    public EdgeList() {
        this.forwardEdges = new HashMap<>();
        this.backwardEdges = new HashMap<>();
    }

    public void addVertex(final Vertex vertex){
        forwardEdges.put(vertex, new ArrayList<>());
        backwardEdges.put(vertex, new ArrayList<>());
    }

    public void addEdge(final Vertex fromVertex, final Vertex toVertex) {
        checkVertexExists(fromVertex);
        checkVertexExists(toVertex);
        addEdgeIfNotContained(forwardEdges.get(fromVertex), fromVertex, toVertex);
        addEdgeIfNotContained(backwardEdges.get(toVertex), toVertex, fromVertex);
    }

    public List<Edge> getForwardEdges(final Vertex vertex) {
        checkVertexExists(vertex);
        return forwardEdges.get(vertex);
    }

    public List<Edge> getBackwardEdges(final Vertex vertex) {
        checkVertexExists(vertex);
        return backwardEdges.get(vertex);
    }

    public List<Edge> getEdges(final Vertex vertex) throws UnknownVertexException {
        List<Edge> edges = new ArrayList<>();
        edges.addAll(getForwardEdges(vertex));
        edges.addAll(getBackwardEdges(vertex));
        return edges;
    }

    private boolean containsEdge(final List<Edge> edges, final Edge edge){
        return edges.contains(edge);
    }

    private void addEdgeIfNotContained(List<Edge> edges, final Vertex fromVertex, final Vertex toVertex){
        Edge edge = new Edge(fromVertex.getId(), toVertex.getId());
        if (!containsEdge(edges, edge)){
            edges.add(edge);
        }
    }

    private void checkVertexExists(final Vertex vertex) {
        if (!forwardEdges.containsKey(vertex)) throw new UnknownVertexException(vertex);
        if (!backwardEdges.containsKey(vertex)) throw new UnknownVertexException(vertex);
    }
}
