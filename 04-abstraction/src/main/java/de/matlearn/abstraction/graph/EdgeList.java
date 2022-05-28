package de.matlearn.abstraction.graph;

import java.io.Serializable;
import java.util.*;

public class EdgeList<Vertex extends GenericVertex> implements Serializable {
    private Map<Vertex, List<Edge>> forwardEdges;
    private Map<Vertex, List<Edge>> backwardEdges;

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

    public void removeEdge(final Vertex vertexFrom, final Vertex vertexTo) {
        if (forwardEdges.containsKey(vertexFrom)){
            forwardEdges.get(vertexFrom).remove(new Edge(vertexFrom.getId(), vertexTo.getId()));
        }
        if (backwardEdges.containsKey(vertexTo)){
            backwardEdges.get(vertexTo).remove(new Edge(vertexTo.getId(), vertexFrom.getId()));
        }
    }

    public void removeAllWithVertex(final Vertex vertex){
        List<Edge> forward = forwardEdges.get(vertex);
        List<Edge> backward = backwardEdges.get(vertex);
        forwardEdges.remove(vertex);
        backwardEdges.remove(vertex);
        Set<Edge> edgesToBeDeleted = new HashSet<>();
        forward.forEach(edge -> edgesToBeDeleted.add(edge.getReverseEdge()));
        backward.forEach(edge -> edgesToBeDeleted.add(edge.getReverseEdge()));
        removeEdgeSet(edgesToBeDeleted);

    }

    private void removeEdgeSet(final Set<Edge> edgesToBeDeleted){
        for (List<Edge> forward : forwardEdges.values()){
            forward.removeAll(edgesToBeDeleted);
        }

        for (List<Edge> backward : backwardEdges.values()){
            backward.removeAll(edgesToBeDeleted);
        }
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
