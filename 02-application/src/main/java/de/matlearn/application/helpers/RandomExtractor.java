package de.matlearn.application.helpers;

import de.matlearn.domain.entities.NamedVertex;
import de.matlearn.domain.exceptions.NoObjectValidationException;

import java.util.List;

public interface RandomExtractor {
    NamedVertex getRandom(final List<NamedVertex> vertices) throws NoObjectValidationException;
}
