package main.java.commands;

import main.java.network.ProofNetworkRepository;
import main.java.parameters.ExactlyOneIdParameter;
import main.java.usecaseparameters.SingleObjectParameters;
import main.java.usecases.ListLeavesUseCase;
import main.java.usecases.MatLearnUseCase;

import java.util.Collections;

public class LeavesCommand extends AbstractCommand {
    public LeavesCommand(){
        super(Collections.singletonList(
                new ExactlyOneIdParameter(1, "Search id", "vertexId")
        ));
    }

    @Override
    public String getName() {
        return "Axioms/Definitions";
    }

    @Override
    public String getHelpText() {
        return "List all axioms and definitions a proven mathematical object relies on.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new ListLeavesUseCase(networkRepository);
    }
}
