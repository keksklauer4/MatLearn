package de.matlearn.domain.exceptions;

public class CycleFoundException extends ValidationException {
    public CycleFoundException() {
        super("Network contains a cycle!");
    }
}
