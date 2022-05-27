package main.java.usecaseparameters;

import main.java.entities.MatType;

import java.util.List;
import java.util.Map;

public class AddMatObjectParameters implements UseCaseParameter {
    private final String name;
    private final String description;
    private final List<Integer> dependencies;
    private final List<Integer> sources;
    private final MatType type;

    public AddMatObjectParameters(String name, String description, List<Integer> dependencies,
                                  List<Integer> sources, MatType type) {
        this.name = name;
        this.description = description;
        this.dependencies = dependencies;
        this.sources = sources;
        this.type = type;
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
