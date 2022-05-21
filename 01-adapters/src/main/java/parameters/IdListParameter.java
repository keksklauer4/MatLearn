package main.java.parameters;

import main.java.validators.InvalidInputException;

import java.util.Objects;

public class IdListParameter implements Parameter {
    private final int id;
    private final String name;
    private String input;

    public IdListParameter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void validateInput(final String input) throws InvalidInputException {
        if (input.strip().matches("([1-9][0-9]*,)*([1-9][0-9]*)"))
            throw new InvalidInputException("Invalid id list supplied!");
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
        IdListParameter that = (IdListParameter) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }
}
