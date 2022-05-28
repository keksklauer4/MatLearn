package main.java.entities;

import main.graph.Graph;
import main.java.exceptions.LeavesNotDefinedValidationException;
import main.java.exceptions.NoTheoremContributionValidationException;
import main.java.exceptions.ValidationException;
import main.java.validators.ContributionValidator;
import main.java.validators.LeafValidator;

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
