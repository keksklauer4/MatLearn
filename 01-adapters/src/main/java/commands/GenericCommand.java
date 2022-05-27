package main.java.commands;

import main.java.network.ProofNetworkRepository;
import main.java.parameters.Parameter;
import main.java.usecases.MatLearnUseCase;
import main.java.validators.InvalidInputException;

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
