package de.matlearn.domain.validators;

import de.matlearn.abstraction.algorithm.CycleChecker;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.exceptions.CycleFoundException;
import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.domain.exceptions.ValidationExceptionHandler;

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
