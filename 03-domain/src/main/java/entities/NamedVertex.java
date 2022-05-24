package main.java.entities;

import main.graph.GenericVertex;
import main.graph.Graph;

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

    public boolean isValid(final Graph<NamedVertex> graph){
        return true;
    }

    public boolean isFullyValid(final Graph<NamedVertex> graph){
        return true;
    }

    public boolean isDefinedType(){
        return isOfType(MatType.AXIOM) || isOfType(MatType.DEFINITION);
    }

    public abstract boolean isOfType(MatType type);
}
