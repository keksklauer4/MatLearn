package main.java.usecaseparameters;

import java.util.Map;

public class SingleObjectParameters implements UseCaseParameter {
    private final Integer vertexId;

    public SingleObjectParameters(Integer vertexId) {
        this.vertexId = vertexId;
    }

    public Integer getVertexId() {
        return vertexId;
    }
}
