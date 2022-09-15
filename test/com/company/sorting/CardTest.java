package com.company.sorting;

import com.company.sorting.oop.Card;
import com.company.sorting.oop.Rank;
import com.company.sorting.oop.Suit;
import org.junit.jupiter.api.Test;

class CardTest {


    @Test
    public void test(){
        Card c1 = new Card(Suit.DIAMONDS, Rank.EIGHT);
        Card c2 = new Card(Suit.HEARTS,Rank.ACE);

        System.out.println(c1.compareTo(c2));

    }
}