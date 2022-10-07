package com.company.search;


import java.util.List;

public class Search {

    public  static <T extends Comparable<T>> int linearSearch(T[] array, T find){
        if(array == null) return -1;
        for (int i = 0; i < array.length; i++) {
            if(find == array[i]) return i;
        }
        return -1;
    }
    public  static <T extends Comparable<T>> int binSearch(T[] array, T find){
        int start = 0; int finish = array.length; int mid=finish;

        while (start<=finish){
            mid = start+(finish-start)/2;
           if(find.compareTo(array[mid])<0){
               finish = mid-1;


           }else if (find.compareTo(array[mid])>0){
               start = mid+1;
           } else {
               return mid;
           }
        }

        return -1;
    }

    public  static <T extends Comparable<T>> int binSearchRec(T[] array, T find){
        return binSearchRec(array, find, 0, array.length);
    }
    public  static <T extends Comparable<T>> int binSearchRec(T[] array, T find, int start, int finish){
        if(start>finish){
            return -1;
        }
            int mid = start+(finish-start)/2;
            if(find.compareTo(array[mid])<0){
                finish = mid-1;
                return binSearchRec(array, find, start, finish);

            }else if (find.compareTo(array[mid])>0){
                start = mid+1;
                return binSearchRec(array, find, start, finish);
            } else {
                return mid;
            }

    }
}
