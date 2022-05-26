package main.java.parameters;

import main.java.validators.InvalidInputException;

import java.lang.reflect.Array;
import java.util.*;

public class IdListParameter implements Parameter {
    private final int id;
    private final String name;
    private final String key;
    private String input;

    public IdListParameter(int id, String name, String key) {
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
        if (!input.strip().matches("(([1-9]([0-9])*,)*([1-9]([0-9])*))?"))
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

    @Override
    public Object getParsedInput() {
        Set<Integer> ids = new HashSet<>();
        if (input != null){
            String[] pieces = input.strip().split(",");
            for (String piece : pieces){
                if (!piece.isBlank()) ids.add(Integer.parseInt(piece));
            }
        }
        return Arrays.asList(ids.toArray());
    }

    @Override
    public String getKey() {
        return this.key;
    }
}
