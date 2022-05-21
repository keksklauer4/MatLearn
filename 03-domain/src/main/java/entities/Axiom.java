package main.java.entities;

import main.graph.Graph;

public class Axiom extends NamedVertex {
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
}
