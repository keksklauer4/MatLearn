package main.java.commands;

import main.java.entities.MatType;
import main.java.network.ProofNetworkRepository;
import main.java.parameters.IdListParameter;
import main.java.parameters.TextInputParameter;
import main.java.usecaseparameters.AddMatObjectParameters;
import main.java.usecases.AddMathematicalObjectTask;
import main.java.usecases.MatLearnUseCase;

import java.util.Arrays;
import java.util.HashMap;

public class AddTheoremCommand extends AbstractCommand {
    public AddTheoremCommand(){
        super(Arrays.asList(
                new TextInputParameter(1, "name", "name"),
                new TextInputParameter(2, "description", "desc"),
                new IdListParameter(3, "dependencies", "deps"),
                new IdListParameter(4, "sources", "sources")
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
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        HashMap<String, Object> parameterMap = getParameterMap();
        parameterMap.put("type", MatType.THEOREM);
        return new AddMathematicalObjectTask(new AddMatObjectParameters(parameterMap), networkRepository);
    }
}
