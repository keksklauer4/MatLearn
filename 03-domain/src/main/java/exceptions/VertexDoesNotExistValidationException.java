package main.java.exceptions;

public class VertexDoesNotExistValidationException extends ValidationException{
    public VertexDoesNotExistValidationException(int id) {
        super("Vertex with id " + id + " does not exist.");
    }
}
