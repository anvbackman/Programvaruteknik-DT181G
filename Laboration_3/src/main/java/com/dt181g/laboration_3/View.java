package com.dt181g.laboration_3;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View extends JPanel {

    private List<Card> cardList;

    public View(List<Card> cardList) {
        this.cardList = cardList;
        setLayout(new GridLayout(4, 4));
        initialize();
    }

    private void initialize() {
        for (Card card : cardList) {
            add(card);
        }
    }
}
