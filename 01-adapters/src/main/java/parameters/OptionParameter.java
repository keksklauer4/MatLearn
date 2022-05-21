package main.java.parameters;

import main.java.validators.InvalidInputException;

import java.util.Arrays;
import java.util.Objects;

public class OptionParameter implements Parameter {
    private final int id;
    private final String name;
    private final String[] options;
    private String input;

    public OptionParameter(int id, String name, String[] options) {
        this.id = id;
        this.name = name;
        this.options = options;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void validateInput(final String input) throws InvalidInputException {
        boolean valid = false;
        for (String option : options) {
            if (input.strip().toUpperCase().equals(option.toUpperCase())) {
                valid = true;
                break;
            }
        }
        if (valid) this.input = input;
        else throw new InvalidInputException("Not a valid option chosen!");
    }

    @Override
    public String getParameterName() {
        return name;
    }

    @Override
    public String getInput() {
        return this.input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptionParameter that = (OptionParameter) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Arrays.equals(options, that.options);
    }
}
