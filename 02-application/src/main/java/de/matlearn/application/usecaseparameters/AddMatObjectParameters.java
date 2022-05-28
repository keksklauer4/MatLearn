package de.matlearn.application.usecaseparameters;

import de.matlearn.domain.entities.MatType;

import java.util.List;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddMatObjectParameters that = (AddMatObjectParameters) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getDependencies() != null ? !getDependencies().equals(that.getDependencies()) : that.getDependencies() != null)
            return false;
        if (getSources() != null ? !getSources().equals(that.getSources()) : that.getSources() != null) return false;
        return getType() == that.getType();
    }
}
