package com.company.graph;

import java.util.List;

public interface GraphI <T>{

    void addVertex(T t);
     void addEdge(T source, T dest);
    int getVertexCount();
    int getEdgeCount();
    boolean hasVertex(T t);
    boolean hasEdge(T source, T destination);
    List<T> getAdjacentNodesOf(T t);
    String toString();

    boolean isDirected();
    List<T> getNodes();

}
