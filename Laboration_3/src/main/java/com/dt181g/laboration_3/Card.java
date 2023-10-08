package com.dt181g.laboration_3;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Card extends JButton {

    private boolean cardMatch;
    private boolean isShowing;
    private BufferedImage image;

    public Card(BufferedImage image) {
        this.image = image;
        this.cardMatch = false;
        this.isShowing = false;
        setPreferredSize(new Dimension(60, 60));
    }


    public boolean isCardMatch() {
        return cardMatch;
    }

    public void setCardMatch(boolean cardMatch) {
        this.cardMatch = cardMatch;
    }

    public void showCard() {
        if (!cardMatch && !isShowing) {
            setIcon(new ImageIcon(image));
            isShowing = true;
        }
    }

    public void hideCard() {
        setText("");
        isShowing = false;
    }

    public BufferedImage getImage() {
        return image;
    }

}
