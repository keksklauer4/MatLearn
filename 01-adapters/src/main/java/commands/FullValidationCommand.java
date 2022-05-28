package main.java.commands;

import main.java.network.ProofNetworkRepository;
import main.java.parameters.Parameter;
import main.java.usecases.FullValidationUseCase;
import main.java.usecases.MatLearnUseCase;

import java.util.ArrayList;
import java.util.List;

public class FullValidationCommand extends AbstractCommand {
    protected FullValidationCommand(List<Parameter> parameters) {
        super(new ArrayList<>());
    }

    @Override
    public String getName() {
        return "Validate network";
    }

    @Override
    public String getHelpText() {
        return "Validate the full network using all rules.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new FullValidationUseCase(networkRepository);
    }
}
