package main.java.entities;

import main.graph.Graph;

import java.io.Serializable;
import java.util.List;

public class Corollary extends NamedVertex implements Serializable {
    public Corollary(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isFullyValid(Graph<NamedVertex> graph) {
        List<NamedVertex> successors = graph.getForwardEdges(this);
        return successors.stream()
                .anyMatch(vertex -> vertex.isOfType(MatType.THEOREM));
    }

    @Override
    public boolean isOfType(MatType type) {
        return false;
    }

    @Override
    public MatType getType() {
        return MatType.COROLLARY;
    }
}
