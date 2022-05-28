package main.java.validators;

import main.algorithm.GenericDFS;
import main.graph.Graph;
import main.java.entities.NamedVertex;
import main.java.exceptions.LeavesNotDefinedValidationException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeafValidator extends GenericDFS<NamedVertex> {
    private Set<NamedVertex> leafs;
    private boolean ranDFS;

    public LeafValidator(Graph<NamedVertex> graph, NamedVertex currentVertex) {
        super(graph, currentVertex);
        this.leafs = new HashSet<>();
        this.ranDFS = false;
    }

    public void allLeafsDefinitionsOrAxioms() throws LeavesNotDefinedValidationException{
        runDFSOnce();
        for (NamedVertex leaf : leafs){
            if (!leaf.isDefinedType())
                throw new LeavesNotDefinedValidationException(getCurrentVertex().get(), leaf);
        }
    }

    private void runDFSOnce(){
        if (!ranDFS){
            runDFS();
            ranDFS = true;
        }
    }

    @Override
    protected void unvisitedVertex(NamedVertex vertex) {
        if (getAdjacent(vertex).isEmpty()){
            leafs.add(vertex);
        }
    }

    @Override
    protected void alreadyVisitedVertex(NamedVertex vertex) { }

    @Override
    protected List<NamedVertex> getAdjacent(NamedVertex vertex) {
        return getGraph().getBackwardEdges(vertex);
    }
}
