package com.company.sorting;

import com.company.sorting.oop.Deck;
import org.junit.jupiter.api.Test;

class SortTest {

    @Test
    public void test(){
        Deck deck = new Deck();
        deck.shuffle();
//        MergeSort.mergeSort(0,51, deck.getDeck());
        BubbleSort.sort(deck.getDeck());

        System.out.println("finito");
    }

}