package main.java.usecases;

import main.java.entities.NamedVertex;
import main.java.exceptions.VertexDoesNotExistValidationException;
import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.usecaseparameters.UseCaseParameter;

import javax.swing.text.html.Option;
import java.util.Optional;

public abstract class AbstractUseCase<T extends UseCaseParameter> implements MatLearnUseCase {
    protected final ProofNetworkRepository networkRepository;
    private final Class<T> expectedParameterType;

    protected AbstractUseCase(ProofNetworkRepository networkRepository, Class<T> expectedParameterType) {
        this.networkRepository = networkRepository;
        this.expectedParameterType = expectedParameterType;
    }

    @Override
    public UseCaseResult execute(UseCaseParameter parameters) {
        if (!checkCorrectParameterType(parameters))
            throw new RuntimeException("Invalid parameter type provided.");
        return executeTyped((T) parameters);
    }

    private boolean checkCorrectParameterType(UseCaseParameter parameters) {
        return expectedParameterType.isInstance(parameters);
    }

    protected abstract UseCaseResult executeTyped(T parameters);

    protected Optional<NamedVertex> getVertexById(int id) {
        NamedVertex vertex = networkRepository.getVertexById(id);
        if (vertex != null) return Optional.of(vertex);
        networkRepository.getExceptionHandler().handle(new VertexDoesNotExistValidationException(id));
        return Optional.empty();
    }
}
