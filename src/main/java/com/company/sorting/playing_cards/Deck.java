package com.company.sorting.playing_cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private Card[] deck;

    public Deck(){
        deck = new Card[52];
        int i = 0;
        for (Suit suit: Suit.values()){
            for (Rank rank : Rank.values()){
                deck[i++] = new Card(suit, rank);
            }
        }
    }


    public void shuffle(){
        List<Card> cards = Arrays.asList(deck);
        Collections.shuffle(cards);
        this.deck = cards.toArray(cards.toArray(new Card[0]));

    }

    public Card[] getDeck() {
        return deck;
    }
}
