package de.matlearn.domain.entities;

import de.matlearn.abstraction.graph.Graph;
import de.matlearn.domain.exceptions.ForwardDependenceValidationException;
import de.matlearn.domain.exceptions.ValidationException;

import java.io.Serializable;

public class Topic extends NamedVertex implements Serializable {
    public Topic(String name, String description) {
        super(name, description);
    }

    @Override
    public void isValid(Graph<NamedVertex> graph) throws ValidationException {
        if (!graph.getForwardEdges(this).isEmpty())
            throw new ForwardDependenceValidationException(this);
    }

    @Override
    public boolean isOfType(MatType type) {
        return type == MatType.TOPIC;
    }

    @Override
    public MatType getType() {
        return MatType.TOPIC;
    }
}
