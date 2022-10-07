package com.company.bst;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BST_test {

    @Test
    public void test(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random r = new Random();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int n = r.nextInt(0,50);
            nums.add(n);
            bst.insert(n);
        }
        System.out.println("end");

    }
}
