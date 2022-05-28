package de.matlearn.application.usecases;

import de.matlearn.application.results.ShowAllObjectsResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.UseCaseParameter;
import de.matlearn.domain.network.ProofNetworkRepository;

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
