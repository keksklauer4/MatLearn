package main.java.network;

import main.graph.Graph;
import main.java.entities.NamedVertex;

import java.util.List;

public interface ProofNetworkRepository {
    void addVertex(NamedVertex vertex);
    void addEdge(NamedVertex fromVertex, NamedVertex toVertex);

    void removeVertex(NamedVertex vertex);
    boolean removeEdgeIfExists(int fromId, int toId);

    List<NamedVertex> getVertices();
    NamedVertex getVertexById(int vertexId);

    Graph<NamedVertex> getGraph();
}
