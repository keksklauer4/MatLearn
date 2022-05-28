package de.matlearn.application.usecases;

import de.matlearn.application.results.FailedUseCaseResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.results.ValidCommandResult;
import de.matlearn.application.usecaseparameters.UseCaseParameter;
import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.domain.validators.FullValidator;

public class FullValidationUseCase implements MatLearnUseCase {
    private final ProofNetworkRepository networkRepository;

    public FullValidationUseCase(ProofNetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    public UseCaseResult execute(UseCaseParameter parameter) {
        FullValidator validator = new FullValidator(networkRepository);
        return validator.isFullyValid() ? new ValidCommandResult() : new FailedUseCaseResult();
    }
}
