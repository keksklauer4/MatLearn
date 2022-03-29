package validators;

import entities.MatType;
import entities.NamedVertex;
import main.algorithm.GenericDFS;
import main.graph.Graph;

import java.util.List;

public class ContributionValidator extends GenericDFS<NamedVertex> {
    private boolean foundContribution;

    public ContributionValidator(Graph<NamedVertex> graph, NamedVertex currentVertex) {
        super(graph, currentVertex);
        this.foundContribution = false;
    }

    public boolean validate(){
        runDFS();
        return foundContribution;
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
