package main.java.network;

import main.algorithm.CycleChecker;
import main.graph.Graph;
import main.graph.UnknownVertexException;
import main.java.entities.NamedVertex;

import java.util.List;

public class ProofNetwork implements ProofNetworkRepository {
    private final ProofNetworkSerializationRepository serializer;
    private Graph<NamedVertex> graph;

    private static ProofNetwork NETWORK;
    public static ProofNetworkSerializationRepository serializationRepository;

    private ProofNetwork(final ProofNetworkSerializationRepository serializer) {
        this.serializer = serializer;
        deserialize();
    }

    public static ProofNetwork getInstance(){
        if (NETWORK == null){
            NETWORK = new ProofNetwork(serializationRepository);
        }
        return NETWORK;
    }

    public void addVertex(NamedVertex vertex) {
        this.graph.registerVertex(vertex);
        serialize();
    }

    public void addEdge(final NamedVertex fromVertex, final NamedVertex toVertex) {
        if (graph.getVertexById(fromVertex.getId()) == null){
            throw new UnknownVertexException(fromVertex);
        }
        else if (graph.getVertexById(toVertex.getId()) == null){
            throw new UnknownVertexException(fromVertex);
        }
        graph.addEdge(fromVertex, toVertex);
        serialize();
    }

    @Override
    public void removeVertex(final NamedVertex vertex) {
        graph.removeVertex(vertex);
        serialize();
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

    @Override
    public List<NamedVertex> getVertices() {
        return graph.getVertices();
    }

    @Override
    public NamedVertex getVertexById(int vertexId) {
        return graph.getVertexById(vertexId);
    }

    @Override
    public void removeEdgeIfExists(int fromId, int toId) {
        graph.removeEdge(fromId, toId);
        serialize();
    }

    @Override
    public Graph<NamedVertex> getGraph() {
        return graph;
    }

    private void serialize(){
        serializer.serialize(this.graph);
    }

    private void deserialize(){
        this.graph = serializer.deserialize();
    }
}
