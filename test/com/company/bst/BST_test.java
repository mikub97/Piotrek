package com.company.bst;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BST_test {
    BinarySearchTree bst ;
    List<Integer> nums;
    public BST_test(){
        this.bst = new BinarySearchTree<>();
        Random r = new Random();
        this.nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int n = r.nextInt(0,50);
            this.nums.add(n);
            this.bst.insert(n);
        }
    }

    @Test
    public void test(){

        System.out.println("end");

    }

    @Test
    public void testMin(){
       System.out.println(this.nums);
       System.out.println("The smallest is " + this.bst.min());

    }
    @Test
    public void testMax(){
        System.out.println(this.nums);
        System.out.println("The biggest is " + this.bst.max());

    }
}
