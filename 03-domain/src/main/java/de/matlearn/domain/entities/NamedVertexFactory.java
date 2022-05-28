package de.matlearn.domain.entities;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NamedVertexFactory {
    private static final Map<MatType, Class<? extends NamedVertex>> vertexTypes = Stream.of(
            new AbstractMap.SimpleEntry<>(MatType.AXIOM, Axiom.class),
            new AbstractMap.SimpleEntry<>(MatType.COROLLARY, Corollary.class),
            new AbstractMap.SimpleEntry<>(MatType.DEFINITION, MathematicalDefinition.class),
            new AbstractMap.SimpleEntry<>(MatType.LEMMA, Lemma.class),
            new AbstractMap.SimpleEntry<>(MatType.SOURCE, Source.class),
            new AbstractMap.SimpleEntry<>(MatType.THEOREM, Theorem.class),
            new AbstractMap.SimpleEntry<>(MatType.TOPIC, Topic.class)
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static NamedVertex create(MatType type, String name, String description){
        Class<? extends NamedVertex> t = getClass(type);
        if (!NamedVertex.class.isAssignableFrom(t)) throw new RuntimeException("Retrieved invalid type.");
        try {
            Constructor<?> ctor = t.getConstructor(String.class, String.class);
            return (NamedVertex) ctor.newInstance(name, description);
        } catch (NoSuchMethodException | InvocationTargetException
                | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("Invalid types.");
        }
    }

    private static Class<? extends NamedVertex> getClass(MatType type) {
        if (!vertexTypes.containsKey(type)) throw new RuntimeException("Invalid type specified!");
        return vertexTypes.get(type);
    }
}
