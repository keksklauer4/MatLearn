package entities;

import main.graph.Graph;

public class Topic extends NamedVertex {
    public Topic(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isValid(Graph<NamedVertex> graph) {
        return graph.getForwardEdges(this).isEmpty();
    }

    @Override
    public boolean isOfType(MatType type) {
        return type == MatType.TOPIC;
    }
}
