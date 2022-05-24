package main.java.entities;

import main.graph.Graph;

import java.io.Serializable;

public class Source extends NamedVertex implements Serializable {
    public Source(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isOfType(MatType type) {
        return  type == MatType.SOURCE;
    }
}
