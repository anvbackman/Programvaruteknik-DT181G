package com.dt181g.laboration_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Model model;
    private View view;
    private Card chosenCard;
    private boolean cardsBeingProcessed = false;
    private int score;
    private int streak = 1;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.score = 0;

        for (Card card : model.getCards()) {
            card.addActionListener(this);
        }

        view.addInstructions(model.getInstructions());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Card currentCard = (Card) e.getSource();

        if (!currentCard.isMatched() && !cardsBeingProcessed) {
            if (chosenCard == null) {
                chosenCard = currentCard;
                chosenCard.showCard();
            } else if (chosenCard == currentCard) {
                chosenCard.hideCard();
                chosenCard = null;
            } else {
                cardsBeingProcessed = true;  // Set the flag to indicate that cards are being processed

                Card secondCard = currentCard;
                currentCard.showCard();

                // Capture values before starting the timer
                int chosenCardValue = chosenCard.getValue();
                int secondCardValue = secondCard.getValue();

                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Use the captured values instead of accessing chosenCard directly
                        if (chosenCardValue != secondCardValue) {
                            chosenCard.hideCard();
                            secondCard.hideCard();
                            streak = 1;  // Reset streak if cards don't match
                        } else {
                            chosenCard.setCardMatch(true);
                            currentCard.setCardMatch(true);
                            model.setScore(streak);
                            streak *= 2;  // Increase streak by a factor of 2
                        }

                        view.updateScore(model.getScore());
                        System.out.println("Score is now: " + model.getScore());
                        if (model.getScore() > model.getHighScore()) {
                            model.setHighScore(model.getScore());
                        }
                        view.updateHighScore(model.getHighScore());

                        chosenCard = null;
                        cardsBeingProcessed = false;  // Reset the flag after processing is complete
                    }
                });

                timer.setRepeats(false);
                timer.start();
            }
        }
    }
}


