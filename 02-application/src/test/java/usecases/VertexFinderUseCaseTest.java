package test.java.usecases;

import main.java.entities.Axiom;
import main.java.entities.NamedVertex;
import main.java.entities.Source;
import main.java.entities.Theorem;
import main.java.network.ProofNetworkRepository;
import main.java.results.FindVertexResult;
import main.java.usecaseparameters.AddConnectionParameters;
import main.java.usecaseparameters.FindVertexParameter;
import main.java.usecases.VertexFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VertexFinderUseCaseTest extends UseCaseTest<FindVertexResult> {
    private ProofNetworkRepository networkRepository;
    private VertexFinder useCase;

    public VertexFinderUseCaseTest() {
        super(FindVertexResult.class);
    }

    @BeforeAll
    void initialize() {
        networkRepository = Mockito.mock(ProofNetworkRepository.class);
        useCase = new VertexFinder(networkRepository);
    }

    @Test
    void test_ValidInput(){
        Mockito.when(networkRepository.getVertices())
                .thenReturn(Arrays.asList(
                        new Axiom("correct", "ignore"),
                        new Theorem("ignore", "correct"),
                        new Source("ignore", "ignore")));

        FindVertexResult res = assertCorrectType(useCase, new FindVertexParameter("correct"));
        Assertions.assertEquals(2, res.getVerticesFound().size());
        assertContainsVertex(res, new Axiom("correct", "ignore"));
        assertContainsVertex(res, new Theorem("ignore", "correct"));
    }

    @Test
    void test_InvalidInput(){
        assertThrow(useCase, new AddConnectionParameters(1, 2), RuntimeException.class);
    }

    private void assertContainsVertex(FindVertexResult result, NamedVertex expected){
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getVerticesFound().stream().anyMatch(vertex ->
                    expected.getName().equals(vertex.getName()) &&
                    expected.getDescription().equals(vertex.getDescription())
        ));
    }
}
