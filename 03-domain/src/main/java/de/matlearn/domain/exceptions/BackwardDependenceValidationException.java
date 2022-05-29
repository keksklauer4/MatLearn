package de.matlearn.domain.exceptions;

import de.matlearn.domain.entities.NamedVertex;

public class BackwardDependenceValidationException extends EntityValidationException {
    public BackwardDependenceValidationException(NamedVertex vertex) {
        super("Object " + vertex.toString() + " depends on some other object.", vertex);
    }
}
