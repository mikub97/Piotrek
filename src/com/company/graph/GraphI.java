package com.company.graph;

public interface GraphI <T>{

    void addVertex(T t);
    void addEdge(T source, T dest);
    int getVertexCount();

    int getEdgeCount();

    boolean hasVertex(T t);

    boolean hasEdge(T source, T destination);

    String toString();

    void DFS_recursive(T t);
}
