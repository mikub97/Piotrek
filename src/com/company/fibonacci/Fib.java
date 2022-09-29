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
    public static int fib_iter(int n) {
        int i = 0;
        int j = 1;
        if (n == 0) {
            return 0;
        }
        for (int k = 1; k < n; k++) {
            int tmp=j;
            j=i+j;
            i=tmp;
        }
        return j;
    }
        public static int fibRabbitsP(int n, int b){
            int m = 0; int im = 1; int tmp;

            for (int i = 0; i < n; i++) {
                tmp = m;
                m+=im;
                im = tmp*b;
            }
            return m;
        }

    public static int fibRabbitsM(int n, int b) {
        int immature = 1;
        int mature=0;
        for(int i =0;i<n;i++) {
            int im = immature;
            immature = mature*b;
            mature = mature+im;
        }
        return mature;
    }
}


