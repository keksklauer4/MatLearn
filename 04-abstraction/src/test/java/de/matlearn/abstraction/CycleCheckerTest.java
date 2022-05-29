package de.matlearn.abstraction;

import de.matlearn.abstraction.algorithm.CycleChecker;
import de.matlearn.abstraction.graph.GenericVertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CycleCheckerTest {

    @Test
    void test_EmptyGraph() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(0);
        assertAcyclic(builder);
    }

    @Test
    void test_SingletonGraph() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(1);
        assertAcyclic(builder);
    }

    @Test
    void test_PathGraph() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(3);
        builder.addEdges(Map.of(
                0, 1,
                1, 2
        ));
        assertAcyclic(builder);
    }

    @Test
    void test_CycleGraph() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(4);
        builder.addEdges(Map.of(
                0, 1,
                1, 2,
                2, 3,
                3, 0
        ));
        assertCyclic(builder);
    }

    @Test
    void test_DisconnectedSingletonGraph() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(10);
        assertAcyclic(builder);
    }

    @Test
    void test_DisconnectedPathGraphs() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(6);
        builder.addEdges(Map.of(
                0, 1,
                1, 2,
                3, 4,
                4, 5
        ));
        assertAcyclic(builder);
    }

    @Test
    void test_DisconnectedOneCycleGraph() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(6);
        builder.addEdges(Map.of(
                0, 1,
                1, 2,
                3, 4,
                4, 5,
                5, 3
        ));
        assertCyclic(builder);
    }

    @Test
    void test_DisconnectedOneCycleLargeNumberSingletonGraph() {
        GraphBuilder builder = new GraphBuilder();
        builder.addVertices(100);
        builder.addEdges(Map.of(
                97, 98,
                98, 99,
                99, 97
        ));
        assertCyclic(builder);
    }

    void assertAcyclic(GraphBuilder builder){
        CycleChecker<GenericVertex> cycleChecker = new CycleChecker<>(builder.getGraph());
        Assertions.assertFalse(cycleChecker.hasCycle());
    }

    void assertCyclic(GraphBuilder builder){
        CycleChecker<GenericVertex> cycleChecker = new CycleChecker<>(builder.getGraph());
        Assertions.assertTrue(cycleChecker.hasCycle());
    }
}
