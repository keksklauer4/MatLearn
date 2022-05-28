package de.matlearn.application.results;

import de.matlearn.domain.entities.NamedVertex;

import java.util.List;

public class FindVertexResult implements UseCaseResult {
    private final String searchString;
    private final List<NamedVertex> verticesFound;

    public FindVertexResult(String searchString, List<NamedVertex> verticesFound) {
        this.searchString = searchString;
        this.verticesFound = verticesFound;
    }

    public String getSearchString() {
        return searchString;
    }

    public List<NamedVertex> getVerticesFound() {
        return verticesFound;
    }
}
