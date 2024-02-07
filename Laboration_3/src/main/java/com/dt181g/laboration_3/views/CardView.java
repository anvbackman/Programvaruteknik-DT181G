package com.dt181g.laboration_3.views;

import javax.swing.*;
import java.awt.*;

/**
 * The CardView class representing the graphical representation of a card in the game Memory.
 * It extends JButton to provide interaction.
 * This class is responsible for the visual presentation of a card.
 *
 * @author Andreas Backman
 */
public class CardView extends JButton {

    private boolean isShowing;

    /**
     * Constructor that initializes a card button.
     */
    public CardView() {
        initcards();
    }

    public void initcards(){
        setText(""); // Sets the text as empty
        this.isShowing = false;
    }



//    public int getCardValue() {
//
//        return Integer.parseInt(getText());

//        String text = getText();
//        if (text.isEmpty()) {
//            return -1;
//        }
//        else {
//            return Integer.parseInt(text);
//        }


    /**
     * Method to show the face of a card and specify if the card is showing.
     *
     * @param value the value to be displayed on the card.
     */
    public void showCard(int value) {
        if (!isShowing) {
            System.out.println("showCard called");
            setText((String.valueOf(value)));
//            setBackground(color);
            isShowing = true;
            repaint();

        }
//        else {
//            setText("");
//            isShowing = false;
//        }

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
        setText("");

        isShowing = false;
        repaint();

    }

    public boolean isShowing() {
        return isShowing;
    }


}
