package com.company.fib;

import com.company.fibonacci.Fib;
import com.company.search.Search;
import org.junit.jupiter.api.Test;

public class SearchTest {
    @Test
    public void test(){
         //System.out.println(Fib.fibRabbits(100,1));
        Integer[] ints = {0,1,3,4,5,6,10,12,15};
        System.out.println(Search.binSearchRec(ints, 11));

    }



}
