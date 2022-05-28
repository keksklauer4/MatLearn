package main.java.exceptions;

import main.java.entities.NamedVertex;

public class BackwardDependenceValidationException extends EntityValidationException {
    public BackwardDependenceValidationException(NamedVertex vertex) {
        super("Object " + vertex.toString() + " depends on some other object.", vertex);
    }
}
