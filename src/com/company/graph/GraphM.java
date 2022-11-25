package com.company.graph;

import java.util.*;

public class GraphM <T extends Comparable<T>> implements GraphI<T>{
    List<List<Integer>> matrix;
    List<T> arr;

    public GraphM(){
        this.matrix  = new ArrayList<>();
        this.arr  = new ArrayList<>();
    }

    public GraphM(int size){
        this(size, true, false);
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

    public void addEdge(T source, T dest, int weight){
        if(!hasVertex(source)) addVertex(source);
        if(!hasVertex(dest)) addVertex(dest);
        if(this.is_directed) {
            this.adjMatrix[getIndex(source)][getIndex(dest)] = weight;
        }else{
            this.adjMatrix[getIndex(source)][getIndex(dest)] = weight;
            this.adjMatrix[getIndex(dest)][getIndex(source)] = weight;

        }
    }

    public int getIndex(T t){
        return this.data.indexOf(t);
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
        if (! hasVertex(source))
            return false;
        if (! hasVertex(destination))
            return false;
        if(is_weighted){
            return (adjMatrix[getIndex(source)][getIndex(destination)]  ==  -1);
        }
        return (adjMatrix[getIndex(source)][getIndex(destination)] == 1);

    }

    @Override
    public List<T> getAdjacents(T t) {
        List<T>  adjacents = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (is_weighted) {
                if (this.adjMatrix[getIndex(t)][i] != -1) {
                    adjacents.add(this.data.get(i));
                }
            }else {
                if (this.adjMatrix[getIndex(t)][i] == 1) {
                    adjacents.add(this.data.get(i));
                }
            }
        }
        adjacents.sort((Comparator<? super T>) Comparator.naturalOrder().reversed());
        return adjacents;
    }

    @Override
    public void DFS(T t) {

    }

    @Override
    public void DFS_recursive(T t) {

    }
}
