package com.company.sorting;

public class Search {
    private String s = "ff";
    private String d = "ff";
    public  <T extends Comparable<T>> int linearSearch(T toFind,T[] array){
        for (int i = 0; i < array.length; i++) {
            if(toFind == array[i]) return i;
        }

        return -1;
    }
}

