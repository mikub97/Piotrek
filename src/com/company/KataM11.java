package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KataM11 {
    public static long nextBiggerNumber(long n) {

        List<Long> digits = toList(n);
        int i = digits.size()-1;
        int j = digits.size()-2;
        boolean swapped = false;
        while ((i>=0) && (j>=0)  ){
            if (digits.get(i)>digits.get(j)) {
                swap(digits,i,j);
                swapped = true;
                break;
            }
            i--;
            j--;
        }
        if (swapped) {
            return toLong(digits);
        }
        else
            return -1;
    }
    public static long toLong(List<Long> digits){
        long number = 0;

        for (int i = digits.size()-1; i >=0; i--) {
            long j = (digits.size()-i-1);
            number+=digits.get(i)*Math.pow(10, j);
        }
        return number;
    }
    public static List<Long> toList(long number) {
        List<Long> digits = new ArrayList<Long>();
        while (number > 0) {
            digits.add(number % 10);
            number = number / 10;
        }
        Collections.reverse(digits);
        return digits;
    }
    private static void swap(List<Long> digits, int i, int j) {{
            long temp = digits.get(i);
            digits.set(i, digits.get(j));
            digits.set(j, temp);
        }
    }
}
