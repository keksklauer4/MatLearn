package de.matlearn.adapters.commands;

import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.application.usecases.FullValidationUseCase;
import de.matlearn.application.usecases.MatLearnUseCase;

import java.util.ArrayList;

public class FullValidationCommand extends AbstractCommand {
    public FullValidationCommand() {
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
