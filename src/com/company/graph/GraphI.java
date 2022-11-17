package com.company.graph;

public interface GraphI <T>{

    void addVertex(T t) throws Exception;

    void addEdge(T source, T dest) throws Exception;

    int getVertexCount();

    int getEdgeCount();

    boolean hasVertex(T t);

    boolean hasEdge(T source, T destination);

    String toString();
}
