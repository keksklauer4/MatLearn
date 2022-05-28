package de.matlearn.domain.network;

import de.matlearn.abstraction.graph.Graph;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.exceptions.ValidationExceptionHandler;

import java.util.List;

public interface ProofNetworkRepository {
    void addVertex(NamedVertex vertex);
    void addEdge(NamedVertex fromVertex, NamedVertex toVertex);

    void removeVertex(NamedVertex vertex);
    boolean removeEdgeIfExists(int fromId, int toId);

    List<NamedVertex> getVertices();
    NamedVertex getVertexById(int vertexId);

    Graph<NamedVertex> getGraph();

    ValidationExceptionHandler getExceptionHandler();
}
