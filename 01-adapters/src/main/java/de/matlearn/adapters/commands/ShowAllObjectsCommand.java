package de.matlearn.adapters.commands;

import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.application.usecases.ShowAllObjectsUseCase;
import de.matlearn.domain.network.ProofNetworkRepository;

public class ShowAllObjectsCommand extends ParameterlessCommand {
    @Override
    public String getName() {
        return "Show all";
    }

    @Override
    public String getHelpText() {
        return "List all mathematical objects available.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new ShowAllObjectsUseCase(networkRepository);
    }
}
