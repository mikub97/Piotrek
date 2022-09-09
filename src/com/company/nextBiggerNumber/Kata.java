package com.company;

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
    public static long nextBiggerNumber(long n) {
        List<Integer> digits = toList(n);
        return toLong(digits);


    }
}
