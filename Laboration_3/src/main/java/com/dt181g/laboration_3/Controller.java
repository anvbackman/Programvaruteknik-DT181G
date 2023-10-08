package com.dt181g.laboration_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Model model;
    private View view;
    private Card chosenCard;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        for (Card card : model.getCards()) {
            card.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (chosenCard == null) {
            chosenCard = (Card) e.getSource();
            chosenCard.showCard();
        }
        else {
            Card secondCard = (Card) e.getSource();
            secondCard.showCard();
            Timer timer = new Timer(1000, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (chosenCard.getImage() != secondCard.getImage()) {
                        chosenCard.hideCard();
                        secondCard.hideCard();
                    }
                    chosenCard = null;
                }
            });
            timer.setRepeats(false);
            timer.start();
        }

    }

}


