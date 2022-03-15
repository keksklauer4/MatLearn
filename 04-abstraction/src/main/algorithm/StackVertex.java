package main.algorithm;

import main.graph.Edge;
import main.graph.GenericVertex;

import java.util.List;

class StackVertex<Vertex extends GenericVertex> {
    private Vertex vertex;
    private List<Vertex> adjacentVertices;
    private int edgeIndex;

    public StackVertex(Vertex vertex, List<Vertex> adjacentVertices) {
        this.vertex = vertex;
        this.adjacentVertices = adjacentVertices;
        edgeIndex = 0;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public boolean hasNext(){
        return false;
    }

    public Vertex getNext(){
        if (!hasNext()){
            return null;
        }
        return adjacentVertices.get(edgeIndex++);
    }
}
