package de.matlearn.application.usecases;

import de.matlearn.application.results.FindVertexResult;
import de.matlearn.domain.entities.Axiom;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.entities.Source;
import de.matlearn.domain.entities.Theorem;
import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.application.usecaseparameters.AddConnectionParameters;
import de.matlearn.application.usecaseparameters.FindVertexParameter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FindVerticesUseCaseUseCaseTest extends UseCaseTest<FindVertexResult> {
    private ProofNetworkRepository networkRepository;
    private FindVerticesUseCase useCase;

    public FindVerticesUseCaseUseCaseTest() {
        super(FindVertexResult.class);
    }

    @BeforeAll
    void initialize() {
        networkRepository = Mockito.mock(ProofNetworkRepository.class);
        useCase = new FindVerticesUseCase(networkRepository);
    }

    @Test
    void test_ValidInput(){
        Mockito.when(networkRepository.getVertices())
                .thenReturn(Arrays.asList(
                        new Axiom("correct", "ignore"),
                        new Theorem("ignore", "cORRect"),
                        new Source("ignore", "ignore")));

        FindVertexResult res = assertCorrectType(useCase, new FindVertexParameter("correct"));
        Assertions.assertEquals(2, res.getVerticesFound().size());
        assertContainsVertex(res, new Axiom("correct", "ignore"));
        assertContainsVertex(res, new Theorem("ignore", "cORRect"));
    }

    @Test
    void test_InvalidInput(){
        assertThrow(useCase, new AddConnectionParameters(1, 2), RuntimeException.class);
    }

    private void assertContainsVertex(FindVertexResult result, NamedVertex expected){
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getVerticesFound().stream().anyMatch(vertex ->
                    expected.getName().equals(vertex.getName()) &&
                    expected.getDescription().equals(vertex.getDescription()) &&
                    expected.getType() == vertex.getType()
        ));
    }
}
