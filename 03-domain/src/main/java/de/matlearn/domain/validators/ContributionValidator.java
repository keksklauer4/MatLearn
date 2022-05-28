package de.matlearn.domain.validators;


import de.matlearn.abstraction.algorithm.GenericDFS;
import de.matlearn.abstraction.graph.Graph;
import de.matlearn.domain.entities.Lemma;
import de.matlearn.domain.entities.MatType;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.exceptions.NoTheoremContributionValidationException;

import java.util.List;

public class ContributionValidator extends GenericDFS<NamedVertex> {
    private final Lemma lemma;
    private boolean foundContribution;

    public ContributionValidator(Graph<NamedVertex> graph, Lemma lemma) {
        super(graph, lemma);
        this.lemma = lemma;
        this.foundContribution = false;
    }

    public void contributesToTheorem() throws NoTheoremContributionValidationException {
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
