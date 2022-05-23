package main.graph;

import java.util.*;

public class Graph<Vertex extends GenericVertex> {
    private HashMap<Integer, Vertex> idToVertex;
    private List<Vertex> vertices;
    private EdgeList edges;
    private int largestId = 0;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.idToVertex = new HashMap<>();
        this.vertices = new ArrayList<>();
    }

    public void registerVertex(Vertex vertex){
        vertex.setId(getNextId());
        vertices.add(vertex);
        idToVertex.put(vertex.getId(), vertex);
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
        return getEndVertices(edges.getBackwardEdges(vertex));
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Vertex> getBackwardEdges(final Vertex vertex){
        return getEndVertices(reverseEdgeList(edges.getBackwardEdges(vertex)));
    }

    private List<Vertex> getEndVertices(final List<Edge> edgeList){
        HashSet<Vertex> endVertices = new HashSet<>();
        for(Edge edge : edgeList){
            endVertices.add(idToVertex.get(edge.getToVertex()));
        }
        return new ArrayList<>(endVertices);
    }

    private List<Edge> reverseEdgeList(final List<Edge> edgeList){
        List<Edge> edgesReversed = new ArrayList<>();
        for (Edge edge : edgeList) {
            edgesReversed.add(edge.getReverseEdge());
        }
        return  edgesReversed;
    }
    private int getNextId(){
        return largestId++;
    }
}
