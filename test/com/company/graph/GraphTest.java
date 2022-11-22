package com.company.graph;

import org.junit.jupiter.api.Test;

public class GraphTest {
    private GraphI<Integer> integerGraph;

    public GraphTest(){
        this.integerGraph = new GraphM<>();
//            integerGraph.addEdge(1,2);
//            integerGraph.addEdge(2,3);
//            integerGraph.addEdge(3,4);
//            integerGraph.addEdge(1,4);
//            integerGraph.addEdge(1,3);

    }
    @Test
    public void test(){
        
    }

    @Test
    public void testDFS(){
        integerGraph.DFS(1);
        System.out.println("next");
        integerGraph.DFS_recursive(1);
    }
    
    
}
