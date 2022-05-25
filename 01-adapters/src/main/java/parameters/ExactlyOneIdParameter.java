package main.java.parameters;

import main.java.validators.InvalidInputException;

public class ExactlyOneIdParameter implements Parameter {
    private final int id;
    private final String name;
    private final String key;
    private String input;

    public ExactlyOneIdParameter(int id, String name, String key) {
        this.id = id;
        this.name = name;
        this.key = key;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void validateInput(final String input) throws InvalidInputException {
        if (parseSingleId(input) == null)
            throw new InvalidInputException("Input is not a single id!");
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
    public Object getParsedInput() throws InvalidInputException {
        Integer parsedId = parseSingleId(this.input);
        if (parsedId == null) throw new InvalidInputException("Invalid parameter supplied!");
        return parsedId;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    private Integer parseSingleId(final String input){
        try {
            return Integer.parseInt(input.strip());
        } catch (Exception e){
            return null;
        }
    }
}
