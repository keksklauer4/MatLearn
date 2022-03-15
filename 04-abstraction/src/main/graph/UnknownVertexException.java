package main.graph;

public class UnknownVertexException extends RuntimeException {
    public UnknownVertexException(final GenericVertex vertex) {
        super("Vertex " + vertex.getId() + " does not exist!");
    }
}
