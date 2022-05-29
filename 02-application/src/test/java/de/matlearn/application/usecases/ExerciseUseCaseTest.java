package de.matlearn.application.usecases;

import de.matlearn.application.results.RandomExerciseResult;
import de.matlearn.application.usecaseparameters.EmptyParameters;
import de.matlearn.domain.entities.Axiom;
import de.matlearn.domain.exceptions.NoObjectValidationException;
import de.matlearn.domain.network.ProofNetworkRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

public class ExerciseUseCaseTest extends UseCaseTest<RandomExerciseResult> {
    private ProofNetworkRepository networkRepository;

    public ExerciseUseCaseTest() {
        super(RandomExerciseResult.class);
    }

    @BeforeEach
    void initialize(){
        networkRepository = Mockito.mock(ProofNetworkRepository.class);
    }

    @Test
    void test_ValidExerciseChosen(){
        Mockito.when(networkRepository.getExceptionHandler()).thenReturn(new ValidationExceptionHandlerMock());
        Mockito.when(networkRepository.getVertices()).thenReturn(Arrays.asList(new Axiom("Test", "Desc")));
        MatLearnUseCase useCase = new ExerciseUseCase(networkRepository, new RandomExtractorMock(0));
        RandomExerciseResult res = assertCorrectType(useCase, new EmptyParameters());

        Assertions.assertEquals("Test", res.getVertex().getName());
        Assertions.assertEquals("Desc", res.getVertex().getDescription());
    }

    @Test
    void test_ThrowsException(){
        Mockito.when(networkRepository.getVertices()).thenReturn(new ArrayList<>());
        MatLearnUseCase useCase = new ExerciseUseCase(networkRepository, new RandomExtractorMock(0));
        assertThrow(useCase, new EmptyParameters(), RuntimeException.class);
    }
}
