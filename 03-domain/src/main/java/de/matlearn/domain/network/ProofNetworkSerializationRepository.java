package de.matlearn.domain.network;

import de.matlearn.abstraction.graph.Graph;
import de.matlearn.domain.entities.NamedVertex;


public interface ProofNetworkSerializationRepository {
    void setPrefix(final String prefix);
    void serialize(final Graph<NamedVertex> proofNetwork);
    Graph<NamedVertex> deserialize();
}

