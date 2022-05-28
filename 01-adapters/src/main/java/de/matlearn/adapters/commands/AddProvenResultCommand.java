package de.matlearn.adapters.commands;

import de.matlearn.adapters.converters.ParameterMapKeys;
import de.matlearn.adapters.parameters.IdListParameter;
import de.matlearn.adapters.parameters.OptionParameter;
import de.matlearn.adapters.parameters.TextInputParameter;
import de.matlearn.application.usecases.AddMathematicalObjectTask;
import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.domain.entities.MatType;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.Arrays;

public class AddProvenResultCommand extends AbstractCommand {
    public AddProvenResultCommand(){
        super(Arrays.asList(
                new OptionParameter(1, "Object type", ParameterMapKeys.TYPE_KEY,
                        new String[]{"Corollary", "Lemma", "Theorem"},
                        new MatType[]{MatType.COROLLARY, MatType.LEMMA, MatType.THEOREM}),
                new TextInputParameter(2, "name", ParameterMapKeys.NAME_KEY),
                new TextInputParameter(3, "description", ParameterMapKeys.DESCRIPTION_KEY),
                new IdListParameter(4, "dependencies", ParameterMapKeys.DEPENDENCIES_KEY),
                new IdListParameter(5, "sources", ParameterMapKeys.SOURCES_KEY)
        ));
    }

    @Override
    public String getName() {
        return "Add a corollary/lemma/theorem";
    }

    @Override
    public String getHelpText() {
        return "Add a proven result which depends on a set of other mathematical objects.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new AddMathematicalObjectTask(networkRepository);
    }
}
