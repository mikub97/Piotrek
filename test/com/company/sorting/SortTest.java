package com.company.sorting;

import com.company.fibonacci.Fib;
import com.company.sorting.oop.Deck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.company.fibonacci.FibTest.writeCSV;

class SortTest {

    private static final String CSV_FILENAME = "SORTING_TIMES.csv";

    @Test
    public void test(){
        Deck deck = new Deck();
        deck.shuffle();
//        MergeSort.mergeSort(0,51, deck.getDeck());
        BubbleSort.sort(deck.getDeck());
        System.out.println("finito");
    }

    @Test
    public void testTimesFib(){
        ArrayList<String> tests = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        Random random = new Random();
        tests.add("i,time_bubble,time_merge");
        for (int j = 0; j < 3000; j++) {
            nums.add(random.nextInt());
        }
        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j < 10; j++) {
                nums.add(random.nextInt());
            }
            Collections.shuffle(nums);
            Integer[] integers = nums.toArray(new Integer[0]);
            long s0 = System.currentTimeMillis();
            BubbleSort.sort(integers);
            long f0 = System.currentTimeMillis();
            long t0 = f0 - s0;
            Collections.shuffle(nums);
            integers = nums.toArray(new Integer[0]);
            long s1 = System.currentTimeMillis();
            MergeSort.sort(integers);
            long f1 = System.currentTimeMillis();
            long t1 = f1 - s1;
            tests.add(nums.size()+","+t0+","+t1);

        }
        writeCSV(tests,CSV_FILENAME);

    }
}