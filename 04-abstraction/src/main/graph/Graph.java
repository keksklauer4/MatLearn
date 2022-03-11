package main.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertices;
    private EdgeList edges;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    private void addVertex(final Vertex vertex){
        vertices.add(vertex);
    }


}
