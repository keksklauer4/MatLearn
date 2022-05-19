package main.java.entities;

import main.graph.Graph;

public class Source extends NamedVertex{
    public Source(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isOfType(MatType type) {
        return  type == MatType.SOURCE;
    }
}
