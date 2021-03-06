package de.matlearn.domain.entities;

import de.matlearn.abstraction.graph.Graph;
import de.matlearn.domain.exceptions.BackwardDependenceValidationException;
import de.matlearn.domain.exceptions.ValidationException;

import java.io.Serializable;

public class Axiom extends NamedVertex implements Serializable {
    public Axiom(String name, String description) {
        super(name, description);
    }

    @Override
    public void isValid(final Graph<NamedVertex> graph) throws ValidationException {
        if (!graph.getBackwardEdges(this).isEmpty())
            throw new BackwardDependenceValidationException(this);
    }

    @Override
    public boolean isOfType(MatType type) {
        return type == MatType.AXIOM;
    }

    @Override
    public MatType getType() {
        return MatType.AXIOM;
    }
}
