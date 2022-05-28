package de.matlearn.adapters.commands;

import de.matlearn.adapters.converters.ParameterMapKeys;
import de.matlearn.domain.entities.MatType;
import de.matlearn.domain.network.ProofNetworkRepository;
import de.matlearn.adapters.parameters.IdListParameter;
import de.matlearn.adapters.parameters.TextInputParameter;
import de.matlearn.application.usecases.AddMathematicalObjectTask;
import de.matlearn.application.usecases.MatLearnUseCase;

import java.util.Arrays;
import java.util.Map;

public class AddTheoremCommand extends AbstractCommand {
    public AddTheoremCommand(){
        super(Arrays.asList(
                new TextInputParameter(1, "name", ParameterMapKeys.NAME_KEY),
                new TextInputParameter(2, "description", ParameterMapKeys.DESCRIPTION_KEY),
                new IdListParameter(3, "dependencies", ParameterMapKeys.DEPENDENCIES_KEY),
                new IdListParameter(4, "sources", ParameterMapKeys.SOURCES_KEY)
        ));
    }

    @Override
    public String getName() {
        return "Add a theorem";
    }

    @Override
    public String getHelpText() {
        return "Add a theorem which depends on a set of other mathematical objects";
    }

    @Override
    public Map<String, Object> getParameterMap() {
        Map<String, Object> parameterMap = super.getParameterMap();
        parameterMap.put("type", MatType.THEOREM);
        return parameterMap;
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new AddMathematicalObjectTask(networkRepository);
    }
}
