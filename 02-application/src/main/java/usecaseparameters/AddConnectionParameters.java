package main.java.usecaseparameters;

import java.util.Map;

public class AddConnectionParameters implements UseCaseParameter {
    private final Integer vertexFromId;
    private final Integer vertexToId;

    public AddConnectionParameters(Integer vertexFromId, Integer vertexToId) {
        this.vertexFromId = vertexFromId;
        this.vertexToId = vertexToId;
    }

    public Integer getVertexFromId() {
        return vertexFromId;
    }

    public Integer getVertexToId() {
        return vertexToId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddConnectionParameters that = (AddConnectionParameters) o;

        if (getVertexFromId() != null ? !getVertexFromId().equals(that.getVertexFromId()) : that.getVertexFromId() != null)
            return false;
        return getVertexToId() != null ? getVertexToId().equals(that.getVertexToId()) : that.getVertexToId() == null;
    }
}
