package main.java.exceptions;

import main.java.entities.NamedVertex;

public class LeavesNotDefinedValidationException extends EntityValidationException {
    public LeavesNotDefinedValidationException(NamedVertex vertex, NamedVertex leaf) {
        super("Object " + vertex.toString() + " has leaves that are neither axioms nor definitions (e. g. "
                + leaf.toString() + ")", vertex);
    }
}
