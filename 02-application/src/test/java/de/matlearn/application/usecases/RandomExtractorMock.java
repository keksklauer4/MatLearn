package de.matlearn.application.usecases;

import de.matlearn.application.helpers.RandomExtractor;
import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.exceptions.NoObjectValidationException;

import java.util.List;

public class RandomExtractorMock implements RandomExtractor {
    private final int index;

    public RandomExtractorMock(int index) {
        this.index = index;
    }

    @Override
    public NamedVertex getRandom(List<NamedVertex> vertices) throws NoObjectValidationException {
        if (vertices.size() <= index) throw new NoObjectValidationException();
        return vertices.get(index);
    }
}
