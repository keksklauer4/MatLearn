package main.java.commands;

import main.java.parameters.ExactlyOneIdParameter;
import main.java.usecases.MatLearnUseCase;

import java.util.Collections;

public class LeavesCommand extends AbstractCommand {
    public LeavesCommand(){
        super(Collections.singletonList(
                new ExactlyOneIdParameter(1, "Search id", "vertexId")
        ));
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getHelpText() {
        return null;
    }

    @Override
    public MatLearnUseCase getParametrizedUseCase() {
        return null;
    }
}
