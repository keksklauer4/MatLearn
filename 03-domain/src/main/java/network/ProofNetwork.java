package main.java.network;

import main.algorithm.CycleChecker;
import main.graph.Graph;
import main.graph.UnknownVertexException;
import main.java.entities.NamedVertex;

public class ProofNetwork implements ProofNetworkRepository {
    private Graph<NamedVertex> graph;

    private static ProofNetwork NETWORK;

    public ProofNetwork() {
        this.graph = new Graph<>();
    }

    public static ProofNetwork getInstance(){
        if (NETWORK == null){
            NETWORK = new ProofNetwork();
        }
        return NETWORK;
    }

    public void addVertex(NamedVertex vertex) {
        this.graph.registerVertex(vertex);
    }

    public void addEdge(final NamedVertex fromVertex, final NamedVertex toVertex) {
        if (graph.getVertexById(fromVertex.getId()) == null){
            throw new UnknownVertexException(fromVertex);
        }
        else if (graph.getVertexById(toVertex.getId()) == null){
            throw new UnknownVertexException(fromVertex);
        }
        graph.addEdge(fromVertex, toVertex);
    }

    public void removeVertex(NamedVertex vertex) {
        // TODO: implement
    }

    public void removeEdge(NamedVertex vertex) {
        // TODO: implement
    }

    public boolean fullValidation() {
        CycleChecker<NamedVertex> cycleChecker = new CycleChecker<NamedVertex>(graph);
        if (cycleChecker.hasCycle()){
            return false;
        }
        for (NamedVertex vertex : graph.getVertices()){
            boolean valid = vertex.isValid(graph) && vertex.isFullyValid(graph);
            if (!valid){
                return false;
            }
        }
        return true;
    }
}
