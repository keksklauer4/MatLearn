package main.java.parameters;

import main.java.validators.InvalidInputException;

public interface Parameter {
    int getId();
    void validateInput(final String input) throws InvalidInputException;
    String getParameterName();

    String getInput();
}
