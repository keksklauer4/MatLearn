package de.matlearn.plugins.plugins;

import de.matlearn.abstraction.graph.Graph;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.network.ProofNetworkSerializationRepository;

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
        File file = new File(prefix);
        if (!file.exists()) return new Graph<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(prefix))){
            return (Graph<NamedVertex>) reader.readObject();
        } catch (FileNotFoundException e) {
            return new Graph<>();
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void createFile(){
        File file = new File(prefix);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) { }
        }
    }
}
