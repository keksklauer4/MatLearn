package de.matlearn.application.usecases;

import de.matlearn.application.helpers.RandomExtractor;
import de.matlearn.application.results.FailedUseCaseResult;
import de.matlearn.application.results.RandomExerciseResult;
import de.matlearn.application.results.UseCaseResult;
import de.matlearn.application.usecaseparameters.UseCaseParameter;
import de.matlearn.domain.entities.MatType;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class ExerciseUseCase implements MatLearnUseCase {
    private final ProofNetworkRepository networkRepository;
    private final RandomExtractor randomExtractor;

    public ExerciseUseCase(ProofNetworkRepository networkRepository, RandomExtractor randomExtractor) {
        this.networkRepository = networkRepository;
        this.randomExtractor = randomExtractor;
    }

    @Override
    public UseCaseResult execute(UseCaseParameter ignored) {
        List<NamedVertex> candidates = networkRepository.getVertices()
                .stream()
                .filter(this::canBeAsked)
                .collect(Collectors.toList());

        AtomicReference<NamedVertex> chosen = new AtomicReference<>();
        networkRepository.getExceptionHandler().handle(() -> {
            chosen.set(randomExtractor.getRandom(candidates));
        });
        return chosen.get() != null ?
                new RandomExerciseResult(chosen.get())
                : new FailedUseCaseResult();
    }

    private boolean canBeAsked(final NamedVertex vertex) {
        return vertex.getType() != MatType.SOURCE &&
                vertex.getType() != MatType.TOPIC;
    }
}
