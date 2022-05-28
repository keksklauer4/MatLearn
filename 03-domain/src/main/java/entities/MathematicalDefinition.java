package main.java.entities;

import java.io.Serializable;

public class MathematicalDefinition extends NamedVertex implements Serializable {
    public MathematicalDefinition(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isOfType(MatType type) {
        return  type == MatType.DEFINITION;
    }

    @Override
    public MatType getType() {
        return MatType.DEFINITION;
    }

    // TODO: implement isValid
}
