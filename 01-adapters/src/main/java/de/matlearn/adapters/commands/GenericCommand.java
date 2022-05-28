package de.matlearn.adapters.commands;

import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.adapters.parameters.Parameter;
import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.adapters.validators.InvalidInputException;

import java.util.List;
import java.util.Map;

public interface GenericCommand {
    List<Parameter> getParameters();
    String getName();
    String getHelpText();
    void setInput(final Parameter p, String input) throws InvalidInputException;
    MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository);
    Map<String, Object> getParameterMap();
}
