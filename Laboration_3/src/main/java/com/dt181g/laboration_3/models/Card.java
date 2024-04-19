package com.dt181g.laboration_3.models;

/**
 * The Card class represents a card in the Memory game
 * @author Andreas Backman
 */
public class Card {
    private final int value;
    private boolean isFaceUp;

    /**
     * Constructor for the Card class that initializes the value of the card
     * @param value the value of the card
     */
    public Card(int value) {
        this.value = value;
        this.isFaceUp = false;
    }

    /**
     * Method to get the value of the card
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * Method to check if the card is face up
     * @return true if the card is face up, false otherwise
     */
    public boolean isFaceUp() {
        return isFaceUp;
    }

    /**
     * Method to flip the card
     */
    public void flip() {
        isFaceUp = !isFaceUp;
    }
}