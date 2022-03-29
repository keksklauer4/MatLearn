package network;

public interface ProofNetworkSerializerRepository {
    void setSuffix(String suffix);
    void serialize(ProofNetworkRepository proofNetwork);
}

