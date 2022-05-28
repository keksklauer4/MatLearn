package de.matlearn.domain.exceptions;

import de.matlearn.domain.entities.Corollary;

public class NoTheoremSuccessorValidationException extends EntityValidationException {
    public NoTheoremSuccessorValidationException(Corollary vertex) {
        super("Corollary " + vertex.toString() + " has no direct successor that is a theorem!", vertex);
    }
}
