package de.matlearn.abstraction.algorithm;

import de.matlearn.abstraction.graph.GenericVertex;
import de.matlearn.abstraction.graph.Graph;

import java.util.*;

public class CycleChecker<Vertex extends GenericVertex> extends GenericDFS<Vertex> {
    private Map<Vertex, Integer> visitedInIteration;
    private Set<Vertex> remainingVertices;
    private int currentIteration;

    public CycleChecker(Graph<Vertex> graph) {
        super(graph);
        this.visitedInIteration = new HashMap<>();
        this.remainingVertices = new HashSet<>(graph.getVertices());
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
        visitedNewVertex(vertex);
        // visitedInIteration.put(vertex, currentIteration);
    }

    @Override
    protected void alreadyVisitedVertex(final Vertex vertex) {
        if (!visitedInIteration.containsKey(vertex)){
            stop();
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
