package de.matlearn.adapters.commands;

import de.matlearn.adapters.parameters.Parameter;
import de.matlearn.adapters.validators.InvalidInputException;
import de.matlearn.application.helpers.RandomExtractorImpl;
import de.matlearn.application.usecases.ExerciseUseCase;
import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseCommand extends ParameterlessCommand {
    @Override
    public String getName() {
        return "Random question";
    }

    @Override
    public String getHelpText() {
        return "You are asked for the description of a random mathematical object.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new ExerciseUseCase(networkRepository, new RandomExtractorImpl());
    }
}
