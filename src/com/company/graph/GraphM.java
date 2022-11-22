package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GraphM <T extends Comparable<T>> implements GraphI<T>{
    List<List<Integer>> matrix;
    List<T> arr;

    public GraphM(){
        this.matrix  = new ArrayList<>();
        this.arr  = new ArrayList<>();
    }


    @Override
    public void addVertex(T t) {
        this.arr.add(t);
        this.matrix.add( new ArrayList<>());
        for (var c : arr) {
            System.out.println(this.matrix.get(0).size());

            if (this.matrix.get(arr.indexOf(c)).size() < arr.size()){
                for (int i = 0; i < arr.size() - this.matrix.get(arr.indexOf(c)).size(); i++) {
                    this.matrix.get(arr.indexOf(c)).add(null);
                }
            }
        }

    }

    @Override
    public void addEdge(T source, T dest) {
        if (!arr.contains(source))  addVertex(source);
        if (!arr.contains(dest)) addVertex(dest);
        this.matrix.get(arr.indexOf(source)).set(arr.indexOf(dest),  1);

    }

    @Override
    public int getVertexCount() {
        return arr.size()+1;
    }

    @Override
    public int getEdgeCount() {
        return 0;
    }

    @Override
    public boolean hasVertex(T t) {
        return arr.contains(t);
    }

    @Override
    public boolean hasEdge(T source, T destination) {
        return false;
    }

    @Override
    public List<T> getAdjacents(T t) {
        return null;
    }

    @Override
    public void DFS(T t) {

    }

    @Override
    public void DFS_recursive(T t) {

    }
}
