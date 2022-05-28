package main.java.plugins;

import main.graph.Graph;
import main.graph.UnknownVertexException;
import main.java.entities.NamedVertex;
import main.java.exceptions.ValidationExceptionHandler;
import main.java.network.ProofNetworkRepository;
import main.java.network.ProofNetworkSerializationRepository;
import main.java.validators.StrictValidator;

import java.util.List;

public class ProofNetwork implements ProofNetworkRepository {
    private final ProofNetworkSerializationRepository serializer;
    private final ValidationExceptionHandler exceptionHandler;
    private Graph<NamedVertex> graph;

    public ProofNetwork(final ProofNetworkSerializationRepository serializer, final ValidationExceptionHandler exceptionHandler) {
        this.serializer = serializer;
        this.exceptionHandler = exceptionHandler;
        deserialize();
    }

    public void addVertex(NamedVertex vertex) {
        this.graph.registerVertex(vertex);
        modifiedGraph();
    }

    public void addEdge(final NamedVertex fromVertex, final NamedVertex toVertex) {
        if (graph.getVertexById(fromVertex.getId()) == null){
            throw new UnknownVertexException(fromVertex);
        }
        else if (graph.getVertexById(toVertex.getId()) == null){
            throw new UnknownVertexException(fromVertex);
        }
        graph.addEdge(fromVertex, toVertex);
        modifiedGraph();
    }

    @Override
    public void removeVertex(final NamedVertex vertex) {
        graph.removeVertex(vertex);
        modifiedGraph();
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
    public boolean removeEdgeIfExists(int fromId, int toId) {
        boolean exists = graph.removeEdge(fromId, toId);
        modifiedGraph();
        return exists;
    }

    @Override
    public Graph<NamedVertex> getGraph() {
        return graph;
    }

    @Override
    public ValidationExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }

    private void modifiedGraph(){
        StrictValidator validator = new StrictValidator(this);
        if (validator.validate()) serialize();
        else deserialize();
    }

    private void serialize(){
        serializer.serialize(this.graph);
    }

    private void deserialize(){
        this.graph = serializer.deserialize();
    }
}
