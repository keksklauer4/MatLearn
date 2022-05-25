package main.java.entities;

import main.graph.Graph;
import main.java.validators.ContributionValidator;
import main.java.validators.LeafValidator;

import java.io.Serializable;

public class Lemma extends NamedVertex implements Serializable {
    public Lemma(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isFullyValid(Graph<NamedVertex> graph) {
        // contributes to at least one theorem
        ContributionValidator validator = new ContributionValidator(graph, this);
        LeafValidator leafValidator = new LeafValidator(graph, this);
        return validator.validate() && leafValidator.allLeafsDefinitionsOrAxioms();
    }

    @Override
    public boolean isOfType(MatType type) {
        return type == MatType.LEMMA;
    }
}
