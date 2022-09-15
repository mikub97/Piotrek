package com.company.nextBiggerNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kata {

    public static List<Integer> toList(long n){
        List<Integer> listOfInputs = new ArrayList<Integer>();
        while ( n > 0 ){
            listOfInputs.add((int)n%10);
            n = n / 10 ;
        }
        Collections.reverse(listOfInputs);
        return listOfInputs;
    }
    public static long toLong(List<Integer> digits){
        int tol= 0;
        int x = 1;
        for (int i = digits.size()-1; i >= 0 ; i--) {
            tol = tol+digits.get(i)*x;
            x= x*10;
        }
        return tol;
    }

    public static <T> void swap(List<T> list, int i , int j ){
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);

    }

    public static long nextBiggerNumber(long n) {
        List<Integer> digits = toList(n);
        for (int i = digits.size()-1; i > 0; i--) {
            if(digits.get(i)>digits.get(i-1)){
                Kata.swap(digits,i,i-1);
                for (int j = i ; j < digits.size()-1 ; j++) {
                    if (digits.get(j) > digits.get(j + 1)) {
                        swap(digits, j, j + 1);
                    }
                }
                return toLong(digits);

            }
        }
        return -1;

    }
}
