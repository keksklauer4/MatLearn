package main.java.validators;

import main.algorithm.CycleChecker;
import main.java.entities.NamedVertex;
import main.java.network.ProofNetworkRepository;

public class FullValidator {
    private final ProofNetworkRepository network;

    public FullValidator(ProofNetworkRepository network) {
        this.network = network;
    }

    public boolean isFullyValid(){
        CycleChecker<NamedVertex> cycleChecker = new CycleChecker<>(network.getGraph());
        if (cycleChecker.hasCycle()){
            return false;
        }
        for (NamedVertex vertex : network.getVertices()){
            boolean valid = vertex.isValid(network.getGraph())
                    && vertex.isFullyValid(network.getGraph());
            if (!valid){
                return false;
            }
        }
        return true;
    }
}
