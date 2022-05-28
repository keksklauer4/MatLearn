package de.matlearn.application.results;

import de.matlearn.domain.entities.NamedVertex;

import java.util.List;

public class ShowAllObjectsResult implements UseCaseResult {
    private final List<NamedVertex> vertices;

    public ShowAllObjectsResult(List<NamedVertex> vertices) {
        this.vertices = vertices;
    }

    public List<NamedVertex> getVertices() {
        return vertices;
    }
}
