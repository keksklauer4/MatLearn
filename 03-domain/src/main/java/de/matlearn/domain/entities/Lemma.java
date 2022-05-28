package de.matlearn.domain.entities;

import de.matlearn.abstraction.graph.Graph;
import de.matlearn.domain.exceptions.ValidationException;
import de.matlearn.domain.validators.ContributionValidator;
import de.matlearn.domain.validators.LeafValidator;

import java.io.Serializable;

public class Lemma extends NamedVertex implements Serializable {
    public Lemma(String name, String description) {
        super(name, description);
    }

    @Override
    public void isFullyValid(Graph<NamedVertex> graph) throws ValidationException {
        ContributionValidator contributionValidator = new ContributionValidator(graph, this);
        LeafValidator leafValidator = new LeafValidator(graph, this);
        contributionValidator.validate();
        leafValidator.allLeafsDefinitionsOrAxioms();
    }

    @Override
    public boolean isOfType(MatType type) {
        return type == MatType.LEMMA;
    }

    @Override
    public MatType getType() {
        return MatType.LEMMA;
    }
}
