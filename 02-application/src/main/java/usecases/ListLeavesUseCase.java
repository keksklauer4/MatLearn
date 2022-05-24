package main.java.usecases;

import main.java.results.UseCaseResult;
import main.java.usecaseparameters.SingleObjectParameters;

public class ListLeavesUseCase implements MatLearnUseCase {
    private final SingleObjectParameters parameters;

    public ListLeavesUseCase(final SingleObjectParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public UseCaseResult execute() {
        return null;
    }
}
