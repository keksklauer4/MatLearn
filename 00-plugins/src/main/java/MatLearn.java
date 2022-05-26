package main.java;

import main.java.cli.CLIHandler;
import main.java.network.ProofNetworkRepository;
import main.java.serialization.ProofNetworkSerializer;

public class MatLearn {
    public static void main(String[] args){
        ProofNetworkRepository network = new ProofNetwork(new ProofNetworkSerializer());
        CLIHandler handler = new CLIHandler(network);
        handler.run();
    }
}
