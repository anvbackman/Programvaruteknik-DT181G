package com.dt181g.laboration_3.models;

import javax.swing.*;

/**
 * The Card class representing the cards use in the game Memory which extends JButton to provide
 * interaction
 *
 * @author Andreas Backman
 */
public class Card extends JButton {

    private int value;
    private boolean cardMatch;
    private boolean isShowing;

    /**
     * Constructor that initializes a card with a specified value
     *
     * @param value the number of cards
     */
    public Card(int value) {
        this.value = value;
        this.cardMatch = false;
        this.isShowing = false;

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

    /**
     * Method to show the face of a card and its value and specify if the card is showing
     */
    public void showCard() {
        if (!cardMatch && !isShowing) {
            setText((String.valueOf(value)));
            isShowing = true;
        }
    }

    /**
     * Method to hide the card
     */
    public void hideCard() {
        setText("");
        isShowing = false;
    }
}