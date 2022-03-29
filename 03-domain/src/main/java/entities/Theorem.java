package entities;

import main.graph.Graph;
import validators.LeafValidator;

import java.util.Set;

public class Theorem extends NamedVertex{
    public Theorem(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isValid(Graph<NamedVertex> graph) {
        return true;
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
