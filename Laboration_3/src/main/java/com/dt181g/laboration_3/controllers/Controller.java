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
    private int streak = 1;

    public Controller() {
        model = new Model();
        view = new View();
        for (int i = 0; i < 16; i++) {
            view.addCardActionListener(i, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 16; i++) {
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
                        Timer timer = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                firstCard.flip();
                                card.flip();
                                view.setCardText(firstCardIndex, "");
                                view.setCardText(secondCardIndex, "");
                                firstCardIndex = -1;
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
}


