package main.java.usecaseparameters;

import java.util.HashMap;

public class SingleObjectParameters {
    private final Integer vertexId;

    public SingleObjectParameters(final HashMap<String, Object> parameters) {
        vertexId = (Integer) parameters.get("vertexId");
    }

    public Integer getVertexId() {
        return vertexId;
    }
}
