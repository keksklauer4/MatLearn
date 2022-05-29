package de.matlearn.domain.entities;

import de.matlearn.abstraction.graph.GenericVertex;
import de.matlearn.abstraction.graph.Graph;
import de.matlearn.domain.exceptions.ValidationException;

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

    @Override
    public String toString() {
        return "{" +
                "id=" + getId() + "," +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + getType().toString() + "'" +
                '}';
    }
}
