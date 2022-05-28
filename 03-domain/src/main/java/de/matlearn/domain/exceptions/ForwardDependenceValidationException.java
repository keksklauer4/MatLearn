package de.matlearn.domain.exceptions;

import de.matlearn.domain.entities.NamedVertex;

public class ForwardDependenceValidationException extends EntityValidationException {
    public ForwardDependenceValidationException(NamedVertex vertex) {
        super("Some other object depends logically on object " + vertex.toString() + ".", vertex);
    }
}