package main.java.usecaseparameters;

import main.java.entities.NamedVertex;

import java.util.Map;

public class FindVertexParameter implements UseCaseParameter {
    private final String search;

    public FindVertexParameter(String search) {
        this.search = search;
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
