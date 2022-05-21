package main.java.parameters;

import main.java.validators.InvalidInputException;

import java.util.Objects;

public class TextInputParameter implements Parameter {
    private final int id;
    private final String name;
    private String input;

    public TextInputParameter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void validateInput(final String input)  throws InvalidInputException {
        if(input.isBlank()) throw new InvalidInputException("The " + name + " parameter cannot be blank!");
        this.input = input;
    }

    @Override
    public String getParameterName() {
        return this.name;
    }

    @Override
    public String getInput() {
        return this.input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextInputParameter that = (TextInputParameter) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }
}
