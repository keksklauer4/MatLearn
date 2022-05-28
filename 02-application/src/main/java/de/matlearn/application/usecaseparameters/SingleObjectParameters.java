package de.matlearn.application.usecaseparameters;

public class SingleObjectParameters implements UseCaseParameter {
    private final Integer vertexId;

    public SingleObjectParameters(Integer vertexId) {
        this.vertexId = vertexId;
    }

    public Integer getVertexId() {
        return vertexId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleObjectParameters that = (SingleObjectParameters) o;

        return getVertexId() != null ? getVertexId().equals(that.getVertexId()) : that.getVertexId() == null;
    }
}
