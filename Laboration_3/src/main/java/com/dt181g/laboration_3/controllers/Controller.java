package com.dt181g.laboration_3.controllers;

import com.dt181g.laboration_3.models.Card;
import com.dt181g.laboration_3.models.Model;
import com.dt181g.laboration_3.views.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener {
    private Model model;
    private View view;
    private int firstCardIndex = -1;
    private boolean isBeingProcessed = false;
    private int amountOfCards;

    public Controller() {

        model = new Model();
        amountOfCards = 16; // The amount of cards in the game
        view = new View(amountOfCards);
        for (int i = 0; i < amountOfCards; i++) {
            view.addCardActionListener(i, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isBeingProcessed) {
            return;
        }

        for (int i = 0; i < amountOfCards; i++) {
            if (e.getSource() == view.getCardButton(i)) {
                Card card = model.getCard(i);
                if (firstCardIndex == -1) {
                    firstCardIndex = i;
                    card.flip();
                    view.setCardText(i, Integer.toString(card.getValue()));
                } else {
                    card.flip();
                    view.setCardText(i, Integer.toString(card.getValue()));
                    Card firstCard = model.getCard(firstCardIndex);
                    if (card.getValue() == firstCard.getValue()) {
                        model.incrementScore();
                        view.setScore(model.getScore());
                        firstCardIndex = -1;
                    } else {
                        int secondCardIndex = i;
                        isBeingProcessed = true;
                        enableButtons(false);
                        Timer timer = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                firstCard.flip();
                                card.flip();
                                view.setCardText(firstCardIndex, "");
                                view.setCardText(secondCardIndex, "");
                                firstCardIndex = -1;
                                isBeingProcessed = false;
                                enableButtons(true);
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                }
                break;
            }
        }
    }

    private void enableButtons(boolean enable) {
        for (int i = 0; i < amountOfCards; i++) {
            view.getCardButton(i).setEnabled(enable);
        }
    }
}


