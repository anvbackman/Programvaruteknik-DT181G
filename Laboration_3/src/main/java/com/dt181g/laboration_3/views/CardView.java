package com.dt181g.laboration_3.views;

import javax.swing.*;

/**
 * The CardView class representing the graphical representation of a card in the game Memory.
 * It extends JButton to provide interaction.
 * This class is responsible for the visual presentation of a card.
 *
 * @author Andreas Backman
 */
public class CardView extends JButton {

    private boolean isShowing;

    private int aa = 99;

    /**
     * Constructor that initializes a card button.
     */
    public CardView() {
        setText(""); // Sets the text as empty
        this.isShowing = false;
    }

    public int getCardValue() {
        return Integer.parseInt(getText());
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
//        SwingUtilities.invokeLater(() -> {
//            setText("");
//            isShowing = false;
//        });
//        showCard();
//        setText(String.valueOf(aa));

        setText("");
        isShowing = false;
        repaint();

    }

    public boolean isShowing() {
        return isShowing;
    }


}
