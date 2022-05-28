package main.java;

import main.java.cli.CLIHandler;
import main.java.cli.CLIPrinter;
import main.java.exceptions.ValidationExceptionHandler;
import main.java.network.ProofNetworkRepository;
import main.java.plugins.ProofNetwork;
import main.java.plugins.ProofNetworkSerializer;
import main.java.plugins.ValidationExceptionHandlerImpl;

public class MatLearn {
    public static void main(String[] args){
        CLIPrinter printer = new CLIPrinter();
        ValidationExceptionHandler exceptionHandler = new ValidationExceptionHandlerImpl(printer);
        ProofNetworkRepository network = new ProofNetwork(new ProofNetworkSerializer(), exceptionHandler);
        CLIHandler handler = new CLIHandler(network);
        handler.run();
    }
}
