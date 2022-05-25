package main.java.network;

import main.graph.Graph;
import main.java.entities.NamedVertex;

public interface ProofNetworkSerializationRepository {
    void setPrefix(final String prefix);
    void serialize(final Graph<NamedVertex> proofNetwork);
    Graph<NamedVertex> deserialize();
}

