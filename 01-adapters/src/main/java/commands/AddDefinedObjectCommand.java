package main.java.commands;

import main.java.entities.MatType;
import main.java.network.ProofNetworkRepository;
import main.java.parameters.IdListParameter;
import main.java.parameters.OptionParameter;
import main.java.parameters.TextInputParameter;
import main.java.usecaseparameters.AddMatObjectParameters;
import main.java.usecases.AddMathematicalObjectTask;
import main.java.usecases.MatLearnUseCase;

import java.util.Arrays;

public class AddDefinedObjectCommand extends AbstractCommand {

    public AddDefinedObjectCommand(){
        super(Arrays.asList(
                new OptionParameter(1, "Object type", "type",
                        new String[]{"Axiom", "Definition"},
                        new MatType[]{MatType.AXIOM, MatType.DEFINITION}),
                new TextInputParameter(2, "name", "name"),
                new TextInputParameter(3, "description", "desc"),
                new IdListParameter(4, "sources", "sources")
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
        return new AddMathematicalObjectTask(new AddMatObjectParameters(getParameterMap()), networkRepository);
    }
}
