package de.matlearn.adapters.parameters;

import de.matlearn.adapters.validators.InvalidInputException;

public interface Parameter {
    int getId();
    void validateInput(final String input) throws InvalidInputException;
    String getParameterName();

    String getInput();

    Object getParsedInput() throws InvalidInputException;
    String getKey();
}
