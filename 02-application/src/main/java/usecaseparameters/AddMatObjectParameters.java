package main.java.usecaseparameters;

import main.java.entities.MatType;

import java.util.HashMap;
import java.util.List;

public class AddMatObjectParameters {
    private final String name;
    private final String description;
    private final List<Integer> dependencies;
    private final List<Integer> sources;
    private final MatType type;

    public AddMatObjectParameters(final HashMap<String, Object> parameters) {
        name = (String) parameters.get("name");
        description = (String) parameters.get("desc");
        dependencies = (List<Integer>) parameters.get("deps");
        sources = (List<Integer>) parameters.get("sources");
        type = (MatType) parameters.get("type");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Integer> getDependencies() {
        return dependencies;
    }

    public List<Integer> getSources() {
        return sources;
    }

    public MatType getType() {
        return type;
    }
}
