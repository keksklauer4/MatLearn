package main.java.results;

import main.java.entities.NamedVertex;

import java.util.List;

public class NeighborResult implements UseCaseResult {
    private final List<NamedVertex> descendants;
    private final List<NamedVertex> parents;

    public NeighborResult(List<NamedVertex> descendants, List<NamedVertex> parents) {
        this.descendants = descendants;
        this.parents = parents;
    }

    public List<NamedVertex> getDescendants() {
        return descendants;
    }

    public List<NamedVertex> getParents() {
        return parents;
    }
}
