package de.matlearn.abstraction.graph;

import java.io.Serializable;
import java.util.*;

public class Graph<Vertex extends GenericVertex> implements Serializable {
    private Map<Integer, Vertex> idToVertex;
    private List<Vertex> vertices;
    private EdgeList<Vertex> edges;
    private int largestId = 0;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.idToVertex = new HashMap<>();
        this.vertices = new ArrayList<>();
        this.edges = new EdgeList<>();
    }

    public void registerVertex(Vertex vertex){
        vertex.setId(getNextId());
        vertices.add(vertex);
        idToVertex.put(vertex.getId(), vertex);
        edges.addVertex(vertex);
    }

    public Vertex getVertexById(int id){
        if(!idToVertex.containsKey(id)){
            return null;
        }
        return idToVertex.get(id);
    }

    public void addEdge(final Vertex vertexFrom, final Vertex vertexTo){
        edges.addEdge(vertexFrom, vertexTo);
    }

    public List<Vertex> getForwardEdges(final Vertex vertex){
        return getEndVertices(edges.getForwardEdges(vertex));
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void removeEdge(final Vertex vertexFrom, final Vertex vertexTo){
        edges.removeEdge(vertexFrom, vertexTo);
    }

    public boolean removeEdge(int fromId, int toId){
        final Vertex vertexFrom = getVertexById(fromId);
        final Vertex vertexTo = getVertexById(toId);
        if (vertexFrom == null || vertexTo == null) return false;
        removeEdge(vertexFrom, vertexTo);
        return true;
    }

    public void removeVertex(final Vertex vertex){
        if (idToVertex.containsKey(vertex.getId())){
            idToVertex.remove(vertex.getId());
            vertices.remove(vertex);
            edges.removeAllWithVertex(vertex);
        }
    }

    public List<Vertex> getBackwardEdges(final Vertex vertex){
        return getEndVertices(edges.getBackwardEdges(vertex));
    }

    private List<Vertex> getEndVertices(final List<Edge> edgeList){
        HashSet<Vertex> endVertices = new HashSet<>();
        edgeList.forEach(edge -> endVertices.add(idToVertex.get(edge.getToVertex())));
        return new ArrayList<>(endVertices);
    }

    private int getNextId(){
        return largestId++;
    }
}
