package main.java.exceptions;

import main.java.entities.NamedVertex;

public class ForwardDependenceValidationException extends EntityValidationException {
    public ForwardDependenceValidationException(NamedVertex vertex) {
        super("Some other object depends logically on object " + vertex.toString() + ".", vertex);
    }
}