package entities;

import main.graph.GenericVertex;
import main.graph.Graph;

public abstract class NamedVertex extends GenericVertex {
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

    public abstract boolean isOfType(MatType type);
}
