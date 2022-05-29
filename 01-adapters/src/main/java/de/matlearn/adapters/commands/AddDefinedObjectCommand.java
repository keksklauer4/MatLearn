package de.matlearn.adapters.commands;

import de.matlearn.adapters.converters.ParameterMapKeys;
import de.matlearn.adapters.parameters.IdListParameter;
import de.matlearn.adapters.parameters.OptionParameter;
import de.matlearn.adapters.parameters.TextInputParameter;
import de.matlearn.application.usecases.AddMathematicalObjectTask;
import de.matlearn.application.usecases.MatLearnUseCase;
import de.matlearn.domain.entities.MatType;
import de.matlearn.domain.network.ProofNetworkRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class AddDefinedObjectCommand extends AbstractCommand {

    public AddDefinedObjectCommand(){
        super(Arrays.asList(
                new OptionParameter(1, "Object type", ParameterMapKeys.TYPE_KEY,
                        new String[]{"Axiom", "Definition"},
                        new MatType[]{MatType.AXIOM, MatType.DEFINITION}),
                new TextInputParameter(2, "name", ParameterMapKeys.NAME_KEY),
                new TextInputParameter(3, "description", ParameterMapKeys.DESCRIPTION_KEY),
                new IdListParameter(4, "sources", ParameterMapKeys.SOURCES_KEY)
        ));
    }

    @Override
    public String getName() {
        return "Add definition or axiom";
    }

    @Override
    public String getHelpText() {
        return "Add a definition or an axiom, that is, a mathematical object without any dependencies.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new AddMathematicalObjectTask(networkRepository);
    }


    @Override
    public Map<String, Object> getParameterMap() {
        Map<String, Object> map = super.getParameterMap();
        map.put(ParameterMapKeys.DEPENDENCIES_KEY, new ArrayList<Integer>());
        return map;
    }
}
