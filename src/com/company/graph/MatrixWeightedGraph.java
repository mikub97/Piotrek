package com.company.graph;

import java.util.*;

public  class MatrixWeightedGraph<T extends Comparable<T>> implements WeightedGraphI<T>{
    private static final double DEFAULT_WEIGHT = -1;
    List<List<Double>> matrix;
    List<T> data;
    private  boolean is_directed;



    public MatrixWeightedGraph(boolean is_directed){
        this.matrix  = new ArrayList<>();
        this.data = new ArrayList<>();
        this.is_directed=is_directed;

    }


    @Override
    public void addVertex(T t) {
        this.data.add(t);
        //adding adjacent for each of existing row
        for (int i = 0; i < this.matrix.size(); i++) {
            matrix.get(i).add(DEFAULT_WEIGHT);
        }
        //adding new adj_list, filling with 0s and one 1 (diagonal)
        List<Double> newList = new ArrayList<>();
        for (int i = 0; i < this.data.size(); i++) {
            newList.add(DEFAULT_WEIGHT);
        }
        this.matrix.add( newList);

    }



    @Override
    public void addEdge(T source, T dest, double weight){
        if(!hasVertex(source)) addVertex(source);
        if(!hasVertex(dest)) addVertex(dest);
        if(this.is_directed) {
            this.matrix.get(getIndex(source)).set(getIndex(dest), weight);
        }else{
            this.matrix.get(getIndex(source)).set(getIndex(dest), weight);
            this.matrix.get(getIndex(dest)).set(getIndex(source), weight);

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
        return (matrix.get(getIndex(source)).get(getIndex(destination)) != DEFAULT_WEIGHT);

    }


    @Override
    public List<T> getAdjacentNodesOf(T t) {
        List<T> adjs = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (this.matrix.get(getIndex(t)).get(i) != DEFAULT_WEIGHT) {
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
    public List<T> getNodes() {
        return data;
    }


    @Override
    public int getVertexCount() {
        return data.size();
    }

    @Override
    public boolean hasVertex(T t) {
        return data.contains(t);
    }


    @Override
    public int getEdgeCount() {
        int tot = 0;
        for (List<Double> list :matrix) {
            for (double i:list) {
                if(i != DEFAULT_WEIGHT )tot++;
            }
        }
        tot = tot-getVertexCount();
        if (!is_directed) return tot/2;
        return tot;
    }

    @Override
    public List<Pair<T, Double>> getAdjacentNodesWithWeightsOf(T t) {
        List<Pair<T, Double>> list = new ArrayList<>();
        return null;
    }
}
