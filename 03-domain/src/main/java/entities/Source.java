package main.java.entities;

import main.graph.Graph;
import main.java.exceptions.ForwardDependenceValidationException;
import main.java.exceptions.ValidationException;

import java.io.Serializable;

public class Source extends NamedVertex implements Serializable {
    public Source(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isOfType(MatType type) {
        return  type == MatType.SOURCE;
    }

    @Override
    public MatType getType() {
        return MatType.SOURCE;
    }

    @Override
    public void isValid(Graph<NamedVertex> graph) throws ValidationException {
        if (!graph.getForwardEdges(this).isEmpty())
            throw new ForwardDependenceValidationException(this);
    }
}
