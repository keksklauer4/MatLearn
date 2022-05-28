package de.matlearn.application.usecases;

import de.matlearn.application.helpers.RandomExtractor;
import de.matlearn.application.results.FailedUseCaseResult;
import de.matlearn.application.results.RandomExerciseResult;
import de.matlearn.application.results.ShowAllObjectsResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.UseCaseParameter;
import de.matlearn.domain.entities.MatType;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class ShowAllObjectsUseCase implements MatLearnUseCase {
    private final ProofNetworkRepository networkRepository;

    public ShowAllObjectsUseCase(ProofNetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    public UseCaseResult execute(UseCaseParameter ignored) {
        return new ShowAllObjectsResult(networkRepository.getVertices());
    }
}
