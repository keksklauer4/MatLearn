package validators;

import entities.NamedVertex;
import main.algorithm.GenericDFS;
import main.graph.Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeafValidator extends GenericDFS<NamedVertex> {
    private Set<NamedVertex> leafs;
    private boolean ranDFS;

    public LeafValidator(Graph<NamedVertex> graph, NamedVertex currentVertex) {
        super(graph, currentVertex);
        this.leafs = new HashSet<NamedVertex>();
        this.ranDFS = false;
    }

    public Set<NamedVertex> getLeafs(){
        runDFSOnce();
        return leafs;
    }

    public boolean allLeafsDefinitionsOrAxioms(){
        runDFSOnce();
        for (NamedVertex leaf : leafs){
            if (!leaf.isDefinedType()){
                return false;
            }
        }
        return true;
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
    protected void alreadyVisitedVertex(NamedVertex vertex) {
        return;
    }

    @Override
    protected List<NamedVertex> getAdjacent(NamedVertex vertex) {
        return getGraph().getBackwardEdges(vertex);
    }
}
