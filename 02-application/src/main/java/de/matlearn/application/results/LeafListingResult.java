package de.matlearn.application.results;

import de.matlearn.domain.entities.NamedVertex;

import java.util.List;

public class LeafListingResult implements UseCaseResult {
    private final List<NamedVertex> leaves;

    public LeafListingResult(List<NamedVertex> leaves) {
        this.leaves = leaves;
    }

    public List<NamedVertex> getLeaves() {
        return leaves;
    }
}
