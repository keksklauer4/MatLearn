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
}
