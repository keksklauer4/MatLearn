package de.matlearn.domain.entities;

import de.matlearn.abstraction.graph.Graph;
import de.matlearn.domain.exceptions.ValidationException;
import de.matlearn.domain.validators.LeafValidator;

import java.io.Serializable;

public class Theorem extends NamedVertex implements Serializable {
    public Theorem(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isOfType(MatType type) {
        return type == MatType.THEOREM;
    }

    @Override
    public void isFullyValid(Graph<NamedVertex> graph) throws ValidationException {
        LeafValidator leafValidator = new LeafValidator(graph, this);
        leafValidator.allLeafsDefinitionsOrAxioms();

    }

    @Override
    public MatType getType() {
        return MatType.THEOREM;
    }
}
