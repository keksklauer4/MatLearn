package main.java.entities;

import main.graph.Graph;
import main.java.exceptions.ValidationException;
import main.java.validators.LeafValidator;

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
