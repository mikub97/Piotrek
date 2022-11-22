package com.company.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

public class MatrixGraphTest<T> {
    private GraphI<Integer> integerGraph;

    public MatrixGraphTest(){
        this.integerGraph = new GraphM<>(10, false,false);
        integerGraph.addEdge(1,2);
        integerGraph.addEdge(2,3);
        integerGraph.addEdge(3,4);
        integerGraph.addEdge(1,4);
        integerGraph.addEdge(1,3);

    }
    @Test
    void addVertexTest(){
        integerGraph.addVertex(10);
        assert integerGraph.hasVertex(10);


    }
    @Test
    public void addEdge(){
        assert  !integerGraph.hasEdge(10,1);
        assert  integerGraph.hasEdge(1,3);
        integerGraph.addEdge(10,1);
        assert  integerGraph.hasEdge(10,1);

    }
    @Test
    public void getVertexCount() {
        assert integerGraph.getVertexCount() ==4;

    }
    @Test
    public void getEdgeCount(){
        System.out.println(integerGraph.getEdgeCount());
        assert integerGraph.getEdgeCount() ==5;

    }

    @Test
    public void hasEdge(){
        assert integerGraph.hasEdge(1,3);
        assert ! integerGraph.hasEdge(2,4);
        assert !integerGraph.hasEdge(2,10);
    }
    @Test
    public void getAdjacents(){
        assert 3==integerGraph.getAdjacents(3).size();
        assert integerGraph.getAdjacents(3).contains(2);
        assert integerGraph.getAdjacents(3).contains(1);
        assert integerGraph.getAdjacents(3).contains(4);

    }

    
    
}
