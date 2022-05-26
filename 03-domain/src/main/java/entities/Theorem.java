package main.java.entities;

import main.graph.Graph;
import main.java.validators.LeafValidator;

import java.io.Serializable;
import java.util.Set;

public class Theorem extends NamedVertex implements Serializable {
    public Theorem(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isOfType(MatType type) {
        return type == MatType.THEOREM;
    }

    @Override
    public boolean isFullyValid(Graph<NamedVertex> graph) {
        LeafValidator leafValidator = new LeafValidator(graph, this);
        return leafValidator.allLeafsDefinitionsOrAxioms();

    }
}
