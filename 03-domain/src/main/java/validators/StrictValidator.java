package main.java.validators;

import main.algorithm.CycleChecker;
import main.java.entities.NamedVertex;
import main.java.exceptions.CycleFoundException;
import main.java.exceptions.ValidationExceptionHandler;
import main.java.network.ProofNetworkRepository;

public class StrictValidator {
    private final ProofNetworkRepository network;
    private final ValidationExceptionHandler exceptionHandler;

    public StrictValidator(final ProofNetworkRepository network) {
        this.network = network;
        this.exceptionHandler = network.getExceptionHandler();
    }

    public boolean validate() {
        boolean valid = exceptionHandler.handle(this::checkForCycles);
        for (final NamedVertex vertex : network.getVertices()){
            valid |= exceptionHandler.handle(() -> vertex.isValid(network.getGraph()));
        }
        return valid;
    }

    private void checkForCycles() throws CycleFoundException {
        CycleChecker<NamedVertex> cycleChecker = new CycleChecker<>(network.getGraph());
        if (cycleChecker.hasCycle()) throw new CycleFoundException();
    }
}
