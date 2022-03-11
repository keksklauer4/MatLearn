package main.graph;

public class UnknownVertexException extends RuntimeException {
    public UnknownVertexException(final Vertex vertex) {
        super("Vertex " + vertex.getId() + " does not exist!");
    }
}
