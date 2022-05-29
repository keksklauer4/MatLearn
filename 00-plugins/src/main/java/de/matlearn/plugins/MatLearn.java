package de.matlearn.plugins;

import de.matlearn.domain.exceptions.ValidationExceptionHandler;
import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.plugins.cli.CLIHandler;
import de.matlearn.plugins.cli.CLIPrinter;
import de.matlearn.plugins.cli.CLIPrinterImpl;
import de.matlearn.plugins.plugins.ProofNetwork;
import de.matlearn.plugins.plugins.ProofNetworkSerializer;
import de.matlearn.plugins.plugins.ValidationExceptionHandlerImpl;

public class MatLearn {
    public static void main(String[] args){
        CLIPrinter printer = new CLIPrinterImpl();
        ValidationExceptionHandler exceptionHandler = new ValidationExceptionHandlerImpl(printer);
        ProofNetworkRepository network = new ProofNetwork(new ProofNetworkSerializer(), exceptionHandler);
        CLIHandler handler = new CLIHandler(network, printer);
        handler.run();
    }
}
