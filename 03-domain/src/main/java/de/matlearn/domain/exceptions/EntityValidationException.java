package de.matlearn.domain.exceptions;

import de.matlearn.domain.entities.NamedVertex;

public class EntityValidationException extends ValidationException {
    private final NamedVertex vertex;

    public EntityValidationException(String message, NamedVertex vertex) {
        super(message);
        this.vertex = vertex;
    }

    public NamedVertex getVertex() {
        return vertex;
    }
}
