package main.java.validators;


import main.algorithm.GenericDFS;
import main.graph.Graph;
import main.java.entities.Lemma;
import main.java.entities.MatType;
import main.java.entities.NamedVertex;
import main.java.exceptions.NoTheoremContributionValidationException;

import java.util.List;

public class ContributionValidator extends GenericDFS<NamedVertex> {
    private final Lemma lemma;
    private boolean foundContribution;

    public ContributionValidator(Graph<NamedVertex> graph, Lemma lemma) {
        super(graph, lemma);
        this.lemma = lemma;
        this.foundContribution = false;
    }

    public void validate() throws NoTheoremContributionValidationException {
        runDFS();
        if (!foundContribution)
            throw new NoTheoremContributionValidationException(lemma);
    }

    @Override
    protected void unvisitedVertex(NamedVertex vertex) {
        foundContribution |= vertex.isOfType(MatType.THEOREM);
    }

    @Override
    protected void alreadyVisitedVertex(NamedVertex vertex) {}

    @Override
    protected List<NamedVertex> getAdjacent(NamedVertex vertex) {
        return getGraph().getForwardEdges(vertex);
    }
}
