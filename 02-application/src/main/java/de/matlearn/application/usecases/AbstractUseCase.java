package de.matlearn.application.usecases;

import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.UseCaseParameter;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.exceptions.VertexDoesNotExistValidationException;
import de.matlearn.domain.network.ProofNetworkRepository;

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
