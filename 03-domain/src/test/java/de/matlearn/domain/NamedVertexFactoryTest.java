package de.matlearn.domain;

import de.matlearn.domain.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class NamedVertexFactoryTest {
    private static final String NAME = "name";
    private static final String DESC = "description";

    private static final Map<MatType, Class<? extends NamedVertex>> vertexTypeMap = Stream.of(
            new AbstractMap.SimpleEntry<>(MatType.AXIOM, Axiom.class),
            new AbstractMap.SimpleEntry<>(MatType.COROLLARY, Corollary.class),
            new AbstractMap.SimpleEntry<>(MatType.DEFINITION, MathematicalDefinition.class),
            new AbstractMap.SimpleEntry<>(MatType.LEMMA, Lemma.class),
            new AbstractMap.SimpleEntry<>(MatType.SOURCE, Source.class),
            new AbstractMap.SimpleEntry<>(MatType.THEOREM, Theorem.class),
            new AbstractMap.SimpleEntry<>(MatType.TOPIC, Topic.class)
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

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

    @Test
    void test_CompleteFactoryTest() {
        for (MatType type : MatType.values()) {
            Assertions.assertTrue(vertexTypeMap.containsKey(type));
            testCreate(type);
        }
    }

    private void assertCorrectType(NamedVertex vertex, MatType type) {
        Assertions.assertEquals(type, vertex.getType());
        Assertions.assertTrue(vertexTypeMap.containsKey(vertex.getType()));
        Assertions.assertEquals(vertexTypeMap.get(type), vertex.getClass());
    }

    private NamedVertex create(MatType type) {
        return NamedVertexFactory.create(type, NAME, DESC);
    }

    private void testCreate(MatType type) {
        assertCorrectType(create(type), type);
    }
}
