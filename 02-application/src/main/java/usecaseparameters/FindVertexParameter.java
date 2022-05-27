package main.java.usecaseparameters;

import main.java.entities.NamedVertex;

import java.util.HashMap;
import java.util.Map;

public class FindVertexParameter {
    private final String search;

    public FindVertexParameter(final Map<String, Object> parameterMap) {
        this.search = ((String) parameterMap.get("search")).strip();
    }

    public String getSearch() {
        return search;
    }

    public boolean matchesSearch(final NamedVertex vertex){
        String lowered = search.toLowerCase();
        return vertex.getName().strip().toLowerCase().contains(lowered)
                || vertex.getDescription().strip().toLowerCase().contains(lowered);
    }
}
