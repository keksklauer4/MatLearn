package network;

import entities.NamedVertex;

public interface ProofNetworkRepository {
    void addVertex(NamedVertex vertex);
    void addEdge(NamedVertex fromVertex, NamedVertex toVertex);

    void removeVertex(NamedVertex vertex);
    void removeEdge(NamedVertex vertex);

    boolean fullValidation();

}
