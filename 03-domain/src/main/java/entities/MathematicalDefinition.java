package main.java.entities;

import main.graph.Graph;

public class MathematicalDefinition extends NamedVertex{
    public MathematicalDefinition(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isOfType(MatType type) {
        return  type == MatType.DEFINITION;
    }
}
