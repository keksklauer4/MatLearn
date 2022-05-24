package main.graph;

import java.io.Serializable;
import java.util.Objects;

public class Edge implements Serializable {
    private int fromVertex;
    private int toVertex;

    public Edge(int fromVertex, int toVertex) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
    }

    public Edge getReverseEdge(){
        return new Edge(toVertex, fromVertex);
    }

    public int getFromVertex() {
        return fromVertex;
    }

    public int getToVertex() {
        return toVertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return fromVertex == edge.fromVertex &&
                toVertex == edge.toVertex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromVertex, toVertex);
    }
}
