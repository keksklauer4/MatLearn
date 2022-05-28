package test.java;

import main.java.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NamedVertexFactoryTest {
    private static final String NAME = "name";
    private static final String DESC = "description";

    @Test
    void test_CreateAxiom(){
        testCreate(MatType.AXIOM);
    }

    @Test
    void test_CreateCorollary(){
        testCreate(MatType.COROLLARY);
    }

    @Test
    void test_CreateDefinition(){
        testCreate(MatType.DEFINITION);
    }

    @Test
    void test_CreateLemma(){
        testCreate(MatType.LEMMA);
    }

    @Test
    void test_CreateSource(){
        testCreate(MatType.SOURCE);
    }

    @Test
    void test_CreateTheorem(){
        testCreate(MatType.THEOREM);
    }

    @Test
    void test_CreateTopic(){
        testCreate(MatType.TOPIC);
    }

    private void assertCorrectType(NamedVertex vertex, MatType type) {
        Assertions.assertEquals(type, vertex.getType());
        switch (type){
            case AXIOM:
                Assertions.assertEquals(Axiom.class, vertex.getClass());
                break;
            case COROLLARY:
                Assertions.assertEquals(Corollary.class, vertex.getClass());
                break;
            case DEFINITION:
                Assertions.assertEquals(MathematicalDefinition.class, vertex.getClass());
                break;
            case LEMMA:
                Assertions.assertEquals(Lemma.class, vertex.getClass());
                break;
            case SOURCE:
                Assertions.assertEquals(Source.class, vertex.getClass());
                break;
            case THEOREM:
                Assertions.assertEquals(Theorem.class, vertex.getClass());
                break;
            case TOPIC:
                Assertions.assertEquals(Topic.class, vertex.getClass());
                break;
            default:
                throw new RuntimeException("Invalid type.");
        }
    }

    private NamedVertex create(MatType type) {
        return NamedVertexFactory.create(type, NAME, DESC);
    }

    private void testCreate(MatType type) {
        assertCorrectType(create(type), type);
    }
}
