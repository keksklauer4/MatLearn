package de.matlearn.application.usecaseparameters;

import java.util.List;

public class RemoveEdgesParameters implements UseCaseParameter {
    private final List<Integer> vertexFromIds;
    private final List<Integer> vertexToIds;

    public RemoveEdgesParameters(List<Integer> vertexFromIds, List<Integer> vertexToIds) {
        this.vertexFromIds = vertexFromIds;
        this.vertexToIds = vertexToIds;
    }

    public List<Integer> getVertexFromIds() {
        return vertexFromIds;
    }

    public List<Integer> getVertexToIds() {
        return vertexToIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemoveEdgesParameters that = (RemoveEdgesParameters) o;

        if (getVertexFromIds() != null ? !getVertexFromIds().equals(that.getVertexFromIds()) : that.getVertexFromIds() != null)
            return false;
        return getVertexToIds() != null ? getVertexToIds().equals(that.getVertexToIds()) : that.getVertexToIds() == null;
    }
}
