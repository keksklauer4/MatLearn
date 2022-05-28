package main.java.entities;

import main.graph.Graph;
import main.java.exceptions.LeavesNotDefinedValidationException;
import main.java.exceptions.NoTheoremSuccessorValidationException;
import main.java.exceptions.ValidationException;
import main.java.validators.LeafValidator;

import java.io.Serializable;
import java.util.List;

public class Corollary extends NamedVertex implements Serializable {
    public Corollary(String name, String description) {
        super(name, description);
    }

    @Override
    public void isFullyValid(Graph<NamedVertex> graph) throws ValidationException {
        List<NamedVertex> successors = graph.getBackwardEdges(this);
        boolean foundSuccessor = successors.stream()
                .anyMatch(vertex -> vertex.isOfType(MatType.THEOREM));
        if (!foundSuccessor) throw new NoTheoremSuccessorValidationException(this);
        LeafValidator leafValidator = new LeafValidator(graph, this);
        leafValidator.allLeafsDefinitionsOrAxioms();
    }

    @Override
    public boolean isOfType(MatType type) {
        return false;
    }

    @Override
    public MatType getType() {
        return MatType.COROLLARY;
    }
}
