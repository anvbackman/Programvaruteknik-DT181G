package com.dt181g.laboration_3.controllers;

import com.dt181g.laboration_3.listeners.CardButtonClickListener;
import com.dt181g.laboration_3.models.Card;
import com.dt181g.laboration_3.models.Model;
import com.dt181g.laboration_3.views.View;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Controller class represents the controller of the Memory game and manages the interaction between the model and the view
 * @author Andreas Backman
 */
public class Controller implements CardButtonClickListener {
    private final Model model;
    private final View view;
    private int firstCardIndex = -1;
    private boolean isBeingProcessed = false;
    private final int amountOfCards;

    /**
<<<<<<< HEAD
     * Constructor for the Controller class
     * Initializes the model and the view and adds action listeners to the card buttons
     */
    public Controller() {
        model = new Model();
        amountOfCards = model.getAmountOfCards();; // The amount of cards in the game
        view = new View(amountOfCards, this);
=======
     * Constructor that takes the model and view as parameters. It then set the score to 0 and adds an action
     * listener to each card
     */
    public Controller() {
        model = new Model();
        view = new View(model.getCards());
        this.score = 0;

        // Adds an action listener to each card in the model
        for (Card card : model.getCards()) {
            card.addActionListener(this);
        }
>>>>>>> new_project
    }


    /**
     * Method to handle the event when a card button is clicked
     * @param index the index of the card button that was clicked
     */
    @Override
    public void cardButtonClicked(int index) {
        if (isBeingProcessed) { // If a pair of cards is being processed
            return;
        }

        Card card = model.getCard(index); // Get the card from the model
        if (card.isFaceUp()) { // If the card is already face up
            return;
        }
        if (firstCardIndex == -1) { // If it's the first card of the pair
            firstCardIndex = index;
            card.flip();
            view.setCardText(index, Integer.toString(card.getValue()));
        } else { // If it's the second card of the pair
            card.flip();
            view.setCardText(index, Integer.toString(card.getValue()));

            Card firstCard = model.getCard(firstCardIndex);
            if (card.getValue() == firstCard.getValue()) { // If the cards is matching
                model.incrementScore();
                view.setScore(model.getScore());
                firstCardIndex = -1;

                if (model.isGameWon()) { // If the game is won
                    view.showGameWonDialog();
                }
            } else {
                int secondCardIndex = index; // Redundant but makes the code below more understandable
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
    }
}


