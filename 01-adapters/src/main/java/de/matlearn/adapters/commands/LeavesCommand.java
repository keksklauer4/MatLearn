package de.matlearn.adapters.commands;

import de.matlearn.adapters.converters.ParameterMapKeys;
import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.adapters.parameters.ExactlyOneIdParameter;
import de.matlearn.application.usecases.ListLeavesUseCase;
import de.matlearn.application.usecases.MatLearnUseCase;

import java.util.Collections;

public class LeavesCommand extends AbstractCommand {
    public LeavesCommand(){
        super(Collections.singletonList(
                new ExactlyOneIdParameter(1, "Search id", ParameterMapKeys.VERTEX_ID_KEY)
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
