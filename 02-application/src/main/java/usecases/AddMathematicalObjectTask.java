package main.java.usecases;

import main.java.entities.MatType;

import java.util.HashMap;
import java.util.List;

public class AddMathematicalObjectTask implements MatLearnUseCase {
    private final String name;
    private final String description;
    private final List<Integer> dependencies;
    private final List<Integer> sources;
    private final MatType type;


    public AddMathematicalObjectTask(final HashMap<String, Object> parameters){
        name = (String) parameters.get("name");
        description = (String) parameters.get("desc");
        dependencies = (List<Integer>) parameters.get("deps");
        sources = (List<Integer>) parameters.get("sources");
        type = (MatType) parameters.get("type");
    }

    @Override
    public void execute() {

    }
}
