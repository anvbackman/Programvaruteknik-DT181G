package com.dt181g.laboration_3.views;

import javax.swing.*;

/**
 * The CardButton class representing the graphical representation of a card in the game Memory.
 * It extends JButton to provide interaction.
 * This class is responsible for the visual presentation of a card.
 * It doesn't contain any logic related to the game's business rules.
 *
 * @author Andreas Backman
 */
public class CardView extends JButton {

    private boolean isShowing;

    /**
     * Constructor that initializes a card button.
     */
    public CardView() {
        this.isShowing = false;
    }

    /**
     * Method to show the face of a card and specify if the card is showing.
     *
     * @param value the value to be displayed on the card.
     */
    public void showCard(int value) {
        if (!isShowing) {
            setText(String.valueOf(value));
            isShowing = true;
        }
    }

    /**
     * Method to hide the card.
     */
    public void hideCard() {
        setText("");
        isShowing = false;
    }
}
