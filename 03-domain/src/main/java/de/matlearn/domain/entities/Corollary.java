package de.matlearn.domain.entities;

import de.matlearn.abstraction.graph.Graph;
import de.matlearn.domain.exceptions.NoTheoremSuccessorValidationException;
import de.matlearn.domain.exceptions.ValidationException;
import de.matlearn.domain.validators.LeafValidator;

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
