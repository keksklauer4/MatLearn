package main.java.usecaseparameters;

import java.util.HashMap;

public class AddConnectionParameters {
    private final Integer vertexFromId;
    private final Integer vertexToId;

    public AddConnectionParameters(final HashMap<String, Object> parameters) {
        vertexFromId = (Integer) parameters.get("fromVertex");
        vertexToId = (Integer) parameters.get("toVertex");
    }

    public Integer getVertexFromId() {
        return vertexFromId;
    }

    public Integer getVertexToId() {
        return vertexToId;
    }
}
