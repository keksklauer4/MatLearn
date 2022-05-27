package main.java.helpers;

import main.algorithm.GenericDFS;
import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListLeaves extends GenericDFS<NamedVertex> {
    private final Set<NamedVertex> leaves;
    private final NamedVertex current;

    public ListLeaves(ProofNetworkRepository network, NamedVertex currentVertex) {
        super(network.getGraph(), currentVertex);
        this.current = currentVertex;
        leaves = new HashSet<>();
    }

    public List<NamedVertex> listLeaves(){
        runDFS();
        return new ArrayList<>(leaves);
    }

    @Override
    protected void unvisitedVertex(NamedVertex vertex) {
        if (getGraph().getBackwardEdges(vertex).size() == 0 && !vertex.equals(current)){
            leaves.add(vertex);
        }
    }

    @Override
    protected void alreadyVisitedVertex(NamedVertex vertex) { }

    @Override
    protected List<NamedVertex> getAdjacent(NamedVertex vertex) {
        return getGraph().getBackwardEdges(vertex);
    }
}
