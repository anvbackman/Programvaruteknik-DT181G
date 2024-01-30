package com.dt181g.laboration_3.models;



/**
 * The Card class representing the cards use in the game Memory
 *
 * @author Andreas Backman
 */
public class Card {

    private int value;
    private boolean cardMatch;

    /**
     * Constructor that initializes a card with a specified value
     *
     * @param value the number of cards
     */
    public Card(int value) {
        this.value = value;
        this.cardMatch = false;
    }

    /**
     * Method to get the card value
     *
     * @return the card value
     */
    public int getValue() {
        return value;
    }

    /**
     * Method to check if a card pair has been matched
     *
     * @return True if cars are matched, false otherwise
     */
    public boolean isMatched() {

        return cardMatch;
    }

    /**
     * Set match status of card
     *
     * @param cardMatch True if the card is matched, false otherwise
     */
    public void setCardMatch(boolean cardMatch) {
        this.cardMatch = cardMatch;
    }
}
