package de.matlearn.domain.exceptions;

import de.matlearn.domain.entities.Lemma;

public class NoTheoremContributionValidationException extends EntityValidationException {
    public NoTheoremContributionValidationException(Lemma vertex) {
        super("Lemma " + vertex.toString() + " does not directly or indirectly contribute to a theorem.", vertex);
    }
}
