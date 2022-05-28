package main.algorithm;

import main.graph.GenericVertex;
import main.graph.Graph;

import java.util.*;

public abstract class GenericDFS<Vertex extends GenericVertex> {
    private final Graph<Vertex> graph;
    private Vertex currentVertex;

    private Set<Vertex> visited;
    private boolean stop;

    public GenericDFS(final Graph<Vertex> graph) {
        this.graph = graph;
        visited = new HashSet<>();
        stop = false;
    }

    public GenericDFS(final Graph<Vertex> graph, Vertex currentVertex) {
        this(graph);
        this.currentVertex = currentVertex;
    }

    protected abstract void unvisitedVertex(final Vertex vertex);
    protected abstract void alreadyVisitedVertex(final Vertex vertex);
    protected abstract List<Vertex> getAdjacent(final Vertex vertex);

    protected void setCurrentVertex(Vertex currentVertex) {
        this.currentVertex = currentVertex;
    }

    protected Graph<Vertex> getGraph(){
        return graph;
    }

    protected void stop(){
        stop = true;
    }

    protected boolean wasStopped(){
        return stop;
    }

    protected void runDFS(){
        Stack<StackVertex<Vertex>> vertexStack = new Stack<>();
        vertexStack.push(visitNext(currentVertex));
        while(!vertexStack.isEmpty() && !stop){
            StackVertex<Vertex> top = vertexStack.peek();
            visited.add(top.getVertex());
            if (!top.hasNext()) vertexStack.pop();
            else tryVisitNext(vertexStack);
        }
    }

    private void tryVisitNext(final Stack<StackVertex<Vertex>> vertexStack){
        Vertex next = vertexStack.peek().getNext();
        if (visited.contains(next)){
            // already visited this node
            alreadyVisitedVertex(next);
        }
        else {
            vertexStack.push(visitNext(next));
        }
    }

    private StackVertex<Vertex> visitNext(Vertex vertex){
        visited.add(vertex);
        unvisitedVertex(vertex);
        return new StackVertex<>(vertex, getAdjacent(vertex));
    }

}
