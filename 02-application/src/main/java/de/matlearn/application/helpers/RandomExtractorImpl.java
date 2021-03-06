package de.matlearn.application.helpers;

import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.exceptions.NoObjectValidationException;

import java.util.List;
import java.util.Random;

public class RandomExtractorImpl implements RandomExtractor {
    @Override
    public NamedVertex getRandom(List<NamedVertex> vertices) throws NoObjectValidationException{
        if (vertices.isEmpty()) throw new NoObjectValidationException();
        Random random = new Random(System.currentTimeMillis());
        return vertices.get(random.nextInt(vertices.size()));
    }
}
