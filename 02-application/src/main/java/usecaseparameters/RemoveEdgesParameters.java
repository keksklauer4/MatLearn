package main.java.usecaseparameters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveEdgesParameters {
    private final List<Integer> vertexFromIds;
    private final List<Integer> vertexToIds;

    public RemoveEdgesParameters(final Map<String, Object> parameters) {
        vertexFromIds = (List<Integer>) parameters.get("vertexIdsFrom");
        vertexToIds = (List<Integer>) parameters.get("vertexIdsTo");
    }

    public List<Integer> getVertexFromIds() {
        return vertexFromIds;
    }

    public List<Integer> getVertexToIds() {
        return vertexToIds;
    }
}
