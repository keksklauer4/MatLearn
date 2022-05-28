package main.java.exceptions;

import main.java.entities.Corollary;

public class NoTheoremSuccessorValidationException extends EntityValidationException {
    public NoTheoremSuccessorValidationException(Corollary vertex) {
        super("Corollary " + vertex.toString() + " has no direct successor that is a theorem!", vertex);
    }
}
