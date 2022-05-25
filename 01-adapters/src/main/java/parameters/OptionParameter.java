package main.java.parameters;

import main.java.validators.InvalidInputException;

import java.util.Arrays;
import java.util.Objects;

public class OptionParameter implements Parameter {
    private final int id;
    private final String name;
    private final String key;
    private final String[] optionNames;
    private final Object[] options;
    private String input;

    public OptionParameter(int id, String name, String key, String[] optionNames, Object[] options) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.optionNames = optionNames;
        this.options = options;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void validateInput(final String input) throws InvalidInputException {
        if (findMatchingOption(input) != -1) this.input = input;
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

    @Override
    public Object getParsedInput() throws InvalidInputException {
        validateInput(this.input);
        return options[findMatchingOption(this.input)];
    }

    private int findMatchingOption(final String input){
        int index = -1;
        for (int i = 0; i < optionNames.length; ++i) {
            if (input != null && input.strip().toUpperCase().equals(optionNames[i].toUpperCase())) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String getKey() {
        return this.key;
    }
}
