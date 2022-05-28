package test.java.usecases;

import main.java.network.ProofNetworkRepository;
import main.java.results.UseCaseResult;
import main.java.results.ValidCommandResult;
import main.java.usecaseparameters.RemoveEdgesParameters;
import main.java.usecaseparameters.UseCaseParameter;
import main.java.usecases.MatLearnUseCase;
import main.java.usecases.RemoveEdgesUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RemoveEdgesUseCaseTest extends UseCaseTest<ValidCommandResult> {
    private MatLearnUseCase useCase;
    private ProofNetworkRepository proofNetworkRepository;
    private Set<Pair<Integer, Integer>> remainingPairs;

    public RemoveEdgesUseCaseTest() {
        super(ValidCommandResult.class);
    }

    @BeforeAll
    void initialize(){
        proofNetworkRepository = Mockito.mock(ProofNetworkRepository.class);
        useCase = new RemoveEdgesUseCase(proofNetworkRepository);
        remainingPairs = new HashSet<>();
    }


    @Test
    void test_AllValidIds(){
        setRemainingPairs(Arrays.asList(new Pair<>(1, 3), new Pair<>(1, 4),
                new Pair<>(2, 3), new Pair<>(2, 4)));
        UseCaseResult res = runUseCase(new RemoveEdgesParameters(Arrays.asList(1,2), Arrays.asList(3,4)));
    }




    private void setRemainingPairs(List<Pair<Integer, Integer>> pairs){
        remainingPairs = new HashSet<>(pairs);
    }

    private UseCaseResult runUseCase(UseCaseParameter parameter){
        Mockito.when(proofNetworkRepository.removeEdgeIfExists(Mockito.anyInt(), Mockito.anyInt()))
                .thenAnswer(invocation -> {
                    Integer from = (Integer) invocation.getArguments()[0];
                    Integer to = (Integer) invocation.getArguments()[1];
                    remainingPairs.remove(new Pair<>(from, to));
                    return true;
                });
        UseCaseResult res = useCase.execute(parameter);
        Assertions.assertTrue(remainingPairs.isEmpty());
        return res;
    }
}
