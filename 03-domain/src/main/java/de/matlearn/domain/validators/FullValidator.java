package de.matlearn.domain.validators;

import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.exceptions.ValidationExceptionHandler;
import de.matlearn.domain.network.ProofNetworkRepository;

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
            valid &= exceptionHandler.handle(() -> vertex.isFullyValid(network.getGraph()));
        }
        return valid;
    }


}
