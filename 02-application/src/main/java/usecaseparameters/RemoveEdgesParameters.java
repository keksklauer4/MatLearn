package main.java.usecaseparameters;

import java.util.List;
import java.util.Map;

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
}
