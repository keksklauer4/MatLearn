package main.java.validators;

import main.algorithm.CycleChecker;
import main.java.entities.NamedVertex;
import main.java.exceptions.CycleFoundException;
import main.java.exceptions.ValidationExceptionHandler;
import main.java.network.ProofNetworkRepository;

public class FullValidator {
    private final ProofNetworkRepository network;
    private final ValidationExceptionHandler exceptionHandler;

    public FullValidator(final ProofNetworkRepository network) {
        this.network = network;
        this.exceptionHandler = network.getExceptionHandler();
    }

    public boolean isFullyValid(){
        boolean valid = (new StrictValidator(network)).validate();
        for (NamedVertex vertex : network.getVertices()){
            valid |= exceptionHandler.handle(() -> vertex.isFullyValid(network.getGraph()));
        }
        return valid;
    }


}
