package main.java.entities;

import main.graph.GenericVertex;
import main.graph.Graph;
import main.java.exceptions.ValidationException;

import java.io.Serializable;

public abstract class NamedVertex extends GenericVertex implements Serializable {
    private String name;
    private String description;

    public NamedVertex(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void isValid(final Graph<NamedVertex> graph) throws ValidationException { }

    public void isFullyValid(final Graph<NamedVertex> graph) throws ValidationException{ }

    public boolean isDefinedType(){
        return isOfType(MatType.AXIOM) || isOfType(MatType.DEFINITION);
    }

    public abstract boolean isOfType(MatType type);

    public abstract MatType getType();
}
