package com.dt181g.laboration_3;

import javax.swing.*;
import java.awt.*;

public class Card extends JButton {

    private int value;
    private boolean cardMatch;
    private boolean isShowing;

    public Card(int value) {
        this.value = value;
        this.cardMatch = false;
        this.isShowing = false;
        setPreferredSize(new Dimension(60, 60));
    }

    public int getValue() {
        return value;
    }

    public boolean isCardMatch() {
        return cardMatch;
    }

    public void setCardMatch(boolean cardMatch) {
        this.cardMatch = cardMatch;
    }

    public void showCard() {
        if (!cardMatch && !isShowing) {
            setText((String.valueOf(value)));
            isShowing = true;
        }
    }

    public void hideCard() {
        setText("");
        isShowing = false;
    }

}
