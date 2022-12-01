package com.company.graph;

import java.util.List;

public interface GraphI <T>{

    void addVertex(T t);
    default void addEdge(T source, T dest){};
    default void addEdge(T source, T dest, double weight){addEdge(source, dest);};
    int getVertexCount();
    int getEdgeCount();
    boolean hasVertex(T t);
    boolean hasEdge(T source, T destination);
    List<T> getAdjacentNodesOf(T t);
    String toString();

    boolean isDirected();
    List<T> getNodes();

}
