package main.java.usecases;

import main.java.network.ProofNetworkRepository;
import main.java.results.FailedUseCaseResult;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.UseCaseParameter;
import main.java.validators.FullValidator;

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
