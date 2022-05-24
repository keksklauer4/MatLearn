package main.resources;

import main.java.network.ProofNetwork;
import main.java.serialization.ProofNetworkSerializer;

public class MatLearn {
    public static void main(String[] args){
        ProofNetwork.serializationRepository = new ProofNetworkSerializer();
        CLIHandler handler = new CLIHandler();
        handler.run();
    }
}
