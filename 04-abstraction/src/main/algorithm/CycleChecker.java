package main.algorithm;

import main.graph.GenericVertex;
import main.graph.Graph;

import java.util.*;

public class CycleChecker<Vertex extends GenericVertex> extends GenericDFS<Vertex> {
    private Map<Vertex, Integer> visitedInIteration;
    private Set<Vertex> remainingVertices;
    private int currentIteration;

    public CycleChecker(Graph<Vertex> graph) {
        super(graph);
        this.visitedInIteration = new HashMap<Vertex, Integer>();
        this.remainingVertices = new HashSet<Vertex>(graph.getVertices());
        this.currentIteration = 0;
    }

    public boolean hasCycle(){
        while(!wasStopped() || !remainingVertices.isEmpty()){
            Vertex v = remainingVertices.iterator().next();
            this.setCurrentVertex(v);
            runDFS();
            currentIteration++;
        }
        return wasStopped();
    }

    @Override
    protected void unvisitedVertex(final Vertex vertex) {
        visitedInIteration.put(vertex, currentIteration);
    }

    @Override
    protected void alreadyVisitedVertex(final Vertex vertex) {
        if (!visitedInIteration.containsKey(vertex)){
            stop(); // error
            return;
        }
        int iteration = visitedInIteration.get(vertex);
        if (iteration >= currentIteration){
            stop();
        }
    }

    @Override
    protected List<Vertex> getAdjacent(final Vertex vertex) {
        return getGraph().getBackwardEdges(vertex);
    }

    private void visitedNewVertex(final Vertex vertex){
        remainingVertices.remove(vertex);
        visitedInIteration.put(vertex, currentIteration);
    }
}
