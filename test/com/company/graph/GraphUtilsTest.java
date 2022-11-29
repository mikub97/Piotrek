package com.company.graph;

import org.junit.jupiter.api.Test;

public class GraphUtilsTest {
    private GraphI<Integer> integerGraph;
    private GraphUtils graphUtils;

    public GraphUtilsTest(){
        this.integerGraph = new MatrixGraph<>(false);
        integerGraph.addVertex(10);
        integerGraph.addEdge(10,73);
        integerGraph.addEdge(10,65);
        integerGraph.addEdge(10,51);
        integerGraph.addEdge(73,2);
        integerGraph.addEdge(73,3);
        integerGraph.addEdge(51,1001);
        integerGraph.addEdge(51,69);
        integerGraph.addEdge(3,1);
        integerGraph.addEdge(3,100);
        integerGraph.addEdge(1001,5);
        integerGraph.addEdge(1001,66);
        integerGraph.addEdge(1001,7);
        integerGraph.addEdge(5,53);
        integerGraph.addEdge(66,6);
        integerGraph.addEdge(7,8);
        integerGraph.addEdge(7,77);
        integerGraph.addEdge(6,-1);
        integerGraph.addEdge(6,54);
        this.graphUtils= new GraphUtils();

    }

    @Test
    void graphutils(){
        System.out.println(graphUtils.BFS(integerGraph, 10));
        //assert integerGraph.hasVertex(10);
    }

    @Test
    void dijstra(){

    }
}
