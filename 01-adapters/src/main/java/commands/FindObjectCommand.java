package main.java.commands;

import main.java.network.ProofNetworkRepository;
import main.java.parameters.TextInputParameter;
import main.java.usecaseparameters.FindVertexParameter;
import main.java.usecases.MatLearnUseCase;
import main.java.usecases.VertexFinder;

import java.util.Collections;

public class FindObjectCommand extends AbstractCommand {
    public FindObjectCommand() {
        super(Collections.singletonList(
                new TextInputParameter(1, "search", "search")
        ));
    }

    @Override
    public String getName() {
        return "Find object";
    }

    @Override
    public String getHelpText() {
        return "Find an object in the proof network given some search string.";
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase(ProofNetworkRepository networkRepository) {
        return new VertexFinder(new FindVertexParameter(getParameterMap()), networkRepository);
    }
}
