package de.matlearn.adapters.commands;

import de.matlearn.adapters.converters.ParameterMapKeys;
import de.matlearn.adapters.parameters.TextInputParameter;
import de.matlearn.application.usecases.FindVerticesUseCase;
import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.Collections;

public class FindObjectCommand extends AbstractCommand {
    public FindObjectCommand() {
        super(Collections.singletonList(
                new TextInputParameter(1, "search", ParameterMapKeys.SEARCH_KEY)
        ));
    }

    @Override
    public String getName() {
        return "Find object";
    }

    @Override
    public String getHelpText() {
        return "Find an object in the proof network given some search string.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new FindVerticesUseCase(networkRepository);
    }
}
