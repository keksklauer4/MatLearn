package main.java;

import main.graph.Graph;
import main.graph.UnknownVertexException;
import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;
import main.java.network.ProofNetworkSerializationRepository;

import java.util.List;

public class ProofNetwork implements ProofNetworkRepository {
    private final ProofNetworkSerializationRepository serializer;
    private Graph<NamedVertex> graph;

    ProofNetwork(final ProofNetworkSerializationRepository serializer) {
        this.serializer = serializer;
        deserialize();
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
