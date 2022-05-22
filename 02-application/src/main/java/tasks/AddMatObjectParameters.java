package main.java.tasks;

import java.util.List;

public class AddMatObjectParameters {
    private final String name;
    private final String description;
    private final List<Integer> dependencies;
    private final List<Integer> sources;

    public AddMatObjectParameters(String name, String description, List<Integer> dependencies, List<Integer> sources) {
        this.name = name;
        this.description = description;
        this.dependencies = dependencies;
        this.sources = sources;
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
}
