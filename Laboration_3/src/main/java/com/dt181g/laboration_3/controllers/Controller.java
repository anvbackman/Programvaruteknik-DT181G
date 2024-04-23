package com.dt181g.laboration_3.controllers;

import com.dt181g.laboration_3.models.Card;
import com.dt181g.laboration_3.models.Model;
import com.dt181g.laboration_3.views.View;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;

/**
 * The Controller class represents the controller of the Memory game and manages the interaction between the model and the view
 * @author Andreas Backman
 */
public class Controller implements ActionListener {
    private final Model model;
    private final View view;
    private int firstCardIndex = -1;
    private boolean isBeingProcessed = false;
    private final int amountOfCards;

    /**
     * Constructor for the Controller class
     * Initializes the model and the view and adds action listeners to the card buttons
     */
    public Controller() {
        model = new Model();
        amountOfCards = model.getAmountOfCards();; // The amount of cards in the game
        view = new View(amountOfCards);
        IntStream.range(0, amountOfCards).forEach(i -> view.addCardActionListener(i, this));
    }

    /**
     * Method to handle the action events for the card buttons
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isBeingProcessed) { // If a pair of cards is being processed
            return;
        }

        for (int i = 0; i < amountOfCards; i++) {
            if (e.getSource() == view.getCardButton(i)) { // If the action event is from a card button
                Card card = model.getCard(i); // Get the card from the model
                if (card.isFaceUp()) { // If the card is already face up
                    return;
                }
                if (firstCardIndex == -1) { // If it's the first card of the pair
                    firstCardIndex = i;
                    card.flip();
                    view.setCardText(i, Integer.toString(card.getValue()));
                } else { // If it's the second card of the pair
                    card.flip();
                    view.setCardText(i, Integer.toString(card.getValue()));

                    Card firstCard = model.getCard(firstCardIndex);
                    if (card.getValue() == firstCard.getValue()) { // If the cards is matching
                        model.incrementScore();
                        view.setScore(model.getScore());
                        firstCardIndex = -1;

                        if (model.isGameWon()) {
                            view.showGameWonDialog();

                        }
                    } else {
                        int secondCardIndex = i;
                        isBeingProcessed = true;

                        Timer timer = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                firstCard.flip();
                                card.flip();
                                view.setCardText(firstCardIndex, "");
                                view.setCardText(secondCardIndex, "");
                                firstCardIndex = -1;
                                isBeingProcessed = false;
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


