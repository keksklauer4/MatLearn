package main.java.usecaseparameters;

import main.java.entities.NamedVertex;

import java.util.HashMap;

public class FindVertexParameter {
    private final String search;

    public FindVertexParameter(final HashMap<String, Object> parameterMap) {
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
