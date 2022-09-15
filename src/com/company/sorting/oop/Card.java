package com.company.sorting.oop;


public class Card implements Comparable<Card> {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }


    public Rank getRank() {
        return rank;
    }

    @Override
    public int compareTo(Card card) {
        if (this.rank.compareTo(card.rank) > 0){
            return 1;
        } else if (this.rank.compareTo(card.rank) < 0){
            return -1;
        } else
            return this.suit.compareTo(card.suit);
    }
}
