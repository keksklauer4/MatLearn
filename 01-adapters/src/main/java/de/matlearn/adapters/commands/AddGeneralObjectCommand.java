package de.matlearn.adapters.commands;

import de.matlearn.adapters.converters.ParameterMapKeys;
import de.matlearn.adapters.parameters.OptionParameter;
import de.matlearn.adapters.parameters.TextInputParameter;
import de.matlearn.application.usecases.AddMathematicalObjectTask;
import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.domain.entities.MatType;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class AddGeneralObjectCommand extends AbstractCommand {
    public AddGeneralObjectCommand() {
        super(Arrays.asList(
                new OptionParameter(1, "Object type", ParameterMapKeys.TYPE_KEY,
                        new String[]{"Source", "Topic"},
                        new MatType[]{MatType.SOURCE, MatType.TOPIC}),
                new TextInputParameter(2, "name", ParameterMapKeys.NAME_KEY),
                new TextInputParameter(3, "description", ParameterMapKeys.DESCRIPTION_KEY)
        ));
    }

    @Override
    public String getName() {
        return "Create source or topic";
    }

    @Override
    public String getHelpText() {
        return "Create a new source or topic with a name and a description.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new AddMathematicalObjectTask(networkRepository);
    }

    @Override
    public Map<String, Object> getParameterMap() {
        Map<String, Object> map = super.getParameterMap();
        map.put(ParameterMapKeys.SOURCES_KEY, new ArrayList<Integer>());
        map.put(ParameterMapKeys.DEPENDENCIES_KEY, new ArrayList<Integer>());
        return map;
    }
}
