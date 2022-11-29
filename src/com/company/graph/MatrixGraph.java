package com.company.graph;

import java.util.*;

public class MatrixGraph<T extends Comparable<T>> implements GraphI<T>{
    List<List<Integer>> matrix;
    List<T> data;
    private  boolean is_directed;


    public MatrixGraph(boolean is_directed){
        this.matrix  = new ArrayList<>();
        this.data = new ArrayList<>();
        this.is_directed=is_directed;
    }


     @Override
    public void addVertex(T t) {
        this.data.add(t);
        //adding adjacent for each of existing row
         for (int i = 0; i < this.matrix.size(); i++) {
             matrix.get(i).add(0);
         }
         //adding new adj_list, filling with 0s and one 1 (diagonal)
         List<Integer> newList = new ArrayList<>();
         for (int i = 0; i < this.data.size()-1; i++) {
             newList.add(0);
         }
         newList.add(1);
        this.matrix.add( newList);

    }


    public void addEdge(T source, T dest){
        if(!hasVertex(source)) addVertex(source);
        if(!hasVertex(dest)) addVertex(dest);
        if(this.is_directed) {
            this.matrix.get(getIndex(source)).set(getIndex(dest), 1);
        }else{
            this.matrix.get(getIndex(source)).set(getIndex(dest), 1);
            this.matrix.get(getIndex(dest)).set(getIndex(source), 1);

        }
    }

    public int getIndex(T t){
        return this.data.indexOf(t);
    }

    @Override
    public boolean hasEdge(T source, T destination) {
        if (! hasVertex(source))
            return false;
        if (! hasVertex(destination))
            return false;
        return (matrix.get(getIndex(source)).get(getIndex(destination)) == 1);

    }


    @Override
    public List<T> getAdjacentNodesOf(T t) {
        List<T> adjs = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (this.matrix.get(getIndex(t)).get(i) == 1) {
                adjs.add(this.data.get(i));
            }
        }
        adjs.remove(t); // removing itself from adjs
        adjs.sort((Comparator<? super T>) Comparator.naturalOrder().reversed());
        return adjs;
    }

    @Override
    public boolean isDirected() {
        return is_directed;
    }


    @Override
    public int getVertexCount() {
        return data.size();
    }

    @Override
    public boolean hasVertex(T t) {
        return data.contains(t);
    }


    //TODO !!
    @Override
    public int getEdgeCount() {
        int tot = 0;
        for (List<Integer> list :matrix) {
            for (int i:list) {
                if(i == 1)tot++;
            }
        }
        tot = tot-getVertexCount();
        if (!is_directed) return tot/2;
        return tot;
    }
}
