package main.java.entities;

import main.graph.Graph;

import java.io.Serializable;

public class Axiom extends NamedVertex implements Serializable {
    public Axiom(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isValid(final Graph<NamedVertex> graph) {
        return graph.getBackwardEdges(this).isEmpty();
    }

    @Override
    public boolean isOfType(MatType type) {
        return type == MatType.AXIOM;
    }

    @Override
    public MatType getType() {
        return MatType.AXIOM;
    }
}
