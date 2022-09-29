package com.company.fibonacci;

public class Fib {

    public static int fib(int n ){
        if (n==0){
            return 0 ;
        }
        if (n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
        public static int fibRabbits(int n, int b){
            int m = 0; int im = 1; int tmp;

            for (int i = 0; i < n; i++) {
                tmp = m;
                m+=im;
                im = tmp*b;
            }
            return m;
        }

}


