package com.company.sorting;

public class BubbleSort {

    public static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    public static  <T extends Comparable<T>> void sort(T[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i].compareTo(array[j])<0){
                    swap(array,i,j);
                }

            }

        }
    }
}
