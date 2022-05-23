package main.java.network;

import main.java.entities.NamedVertex;

import java.util.List;

public interface ProofNetworkRepository {
    void addVertex(NamedVertex vertex);
    void addEdge(NamedVertex fromVertex, NamedVertex toVertex);

    void removeVertex(NamedVertex vertex);
    void removeEdge(NamedVertex vertex);

    boolean fullValidation();
    List<NamedVertex> getVertices();

}
