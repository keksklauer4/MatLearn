package main.java.serialization;

import main.graph.Graph;
import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkSerializationRepository;

import java.io.*;

public class ProofNetworkSerializer implements ProofNetworkSerializationRepository {
    private String prefix;

    public ProofNetworkSerializer() {
        this.prefix = "ProofNetworkStorage";
    }

    @Override
    public void setPrefix(final String prefix) {
        if (prefix.strip().isEmpty()) return;
        this.prefix = prefix;
    }

    @Override
    public void serialize(final Graph<NamedVertex> proofNetwork) {
        if (proofNetwork == null) return;
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(prefix, false))) {
            writer.writeObject(proofNetwork);
        } catch (IOException ex) {
            throw new RuntimeException("Could not persist proof network to file!");
        }
    }

    @Override
    public Graph<NamedVertex> deserialize() {
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(prefix))){
            return (Graph<NamedVertex>) reader.readObject();
        } catch (FileNotFoundException e) {
            return new Graph<NamedVertex>();
        } catch (IOException e) {
            throw new RuntimeException("Could not read file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
