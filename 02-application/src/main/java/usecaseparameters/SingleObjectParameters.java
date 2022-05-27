package main.java.usecaseparameters;

import java.util.HashMap;
import java.util.Map;

public class SingleObjectParameters {
    private final Integer vertexId;

    public SingleObjectParameters(final Map<String, Object> parameters) {
        vertexId = (Integer) parameters.get("vertexId");
    }

    public Integer getVertexId() {
        return vertexId;
    }
}
