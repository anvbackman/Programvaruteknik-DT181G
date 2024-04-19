package com.dt181g.laboration_3.models;

public class Card {
    private int value;
    private boolean isFaceUp;

    public Card(int value) {
        this.value = value;
        this.isFaceUp = false;
    }

    public int getValue() {
        return value;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }
}