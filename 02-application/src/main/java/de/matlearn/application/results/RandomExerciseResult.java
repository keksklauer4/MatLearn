package de.matlearn.application.results;

import de.matlearn.domain.entities.NamedVertex;

public class RandomExerciseResult implements UseCaseResult {
    private final NamedVertex vertex;

    public RandomExerciseResult(NamedVertex vertex) {
        this.vertex = vertex;
    }

    public NamedVertex getVertex() {
        return vertex;
    }
}
