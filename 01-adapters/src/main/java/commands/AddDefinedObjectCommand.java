package main.java.commands;

import main.java.converters.ParameterMapKeys;
import main.java.entities.MatType;
import main.java.network.ProofNetworkRepository;
import main.java.parameters.IdListParameter;
import main.java.parameters.OptionParameter;
import main.java.parameters.TextInputParameter;
import main.java.usecases.AddMathematicalObjectTask;
import main.java.usecases.MatLearnUseCase;

import java.util.Arrays;

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
}
