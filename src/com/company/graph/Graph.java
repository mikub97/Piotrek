package com.company.graph;

import java.util.*;
import java.util.stream.Collectors;

public class Graph <T extends Comparable<T>> implements GraphI<T>{

    private Map<T, List<T>> adjacencyList;
    private boolean isBidirect;
    private List<T> visited = new ArrayList<>();


    public Graph(boolean isBidirect){
        this.adjacencyList = new HashMap<>();
        this.isBidirect = isBidirect;
    }

    public Graph(){
         this(true);
    }

    @Override
    public void addVertex(T t) {
        if(! adjacencyList.containsKey(t))   adjacencyList.put(t, new ArrayList<>());

    }

    @Override
    public void addEdge(T source, T dest) {
        if (!adjacencyList.containsKey(source)) addVertex(source);
        if (!adjacencyList.containsKey(dest)) addVertex(dest);
        if (this.isBidirect) {
            if (!adjacencyList.get(source).contains(dest)) adjacencyList.get(source).add(dest);
            if (!adjacencyList.get(dest).contains(source)) adjacencyList.get(dest).add(source);
            else if (!adjacencyList.get(source).contains(dest)) adjacencyList.get(source).add(dest);
        }
    }

    @Override
    public int getVertexCount() {
        return adjacencyList.size();
    }

    @Override
    public int getEdgeCount() {
        int c=0;
        for (var adj: adjacencyList.values()) {
            c += adj.size();

        }
        if (this.isBidirect)
            return c/2;
        else return c;
    }

    @Override
    public boolean hasVertex(T t) {
        return adjacencyList.containsKey(t);
    }

    @Override
    public boolean hasEdge(T source, T dest) {
        return adjacencyList.get(source).contains(dest);
    }

    public List<T> getAdjacents(T t){
        List<T> adjs = adjacencyList.get(t);
        adjs.sort((Comparator<? super T>) Comparator.naturalOrder().reversed());
        return adjs;
    }

    public void DFS(T t){
        List<T> visited = new ArrayList<>();
        Stack<T> stack = new Stack<>();
        stack.push(t);
        while(!stack.empty()){
            T cur = stack.pop();
            if (!visited.contains(cur)){
                System.out.println(cur);
                visited.add(cur);
            }
            List<T> adjs = this.getAdjacents(cur);
            adjs.sort(new Comparator<T>() {
                @Override
                public int compare(T o1, T o2) {
                    return o1.compareTo(o2);
                }
            });
            for (int i = 0; i < adjs.size(); i++) {
                if (!visited.contains(adjs.get(i))){
                    stack.push(adjs.get(i));
                }
            }

        }
    }

    private void DFS_rec(T t){
        this.visited.add(t);
        System.out.println(t);
        List<T> adjs = this.getAdjacents(t);
        adjs.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < adjs.size(); i++) {
            if (!visited.contains(adjs.get(i)))
                DFS_rec(adjs.get(i));
        }
    }
    @Override
    public void DFS_recursive(T t){
        this.visited = new ArrayList<>();
        DFS_rec(t);
    }
}
