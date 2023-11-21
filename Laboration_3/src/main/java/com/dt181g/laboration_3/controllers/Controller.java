package com.dt181g.laboration_3.controllers;

import com.dt181g.laboration_3.models.Card;
import com.dt181g.laboration_3.models.Model;
import com.dt181g.laboration_3.views.View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Controller class that handles user interactions an update the model and view classes based on it
 *
 * @author Andreas Backman
 */
public class Controller implements ActionListener {

    private Model model;
    private View view;
    private Card chosenCard;
    private boolean cardsBeingProcessed = false;
    private int score;
    private int streak = 1;

    /**
     * Constructor that takes the model and view as parameters. It then set the score to 0 and adds an action
     * listener to each card
     *
     * @param model the model containing game logic
     * @param view the view displaying the game
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.score = 0;

        // Adds an action listener to each card in the model
        for (Card card : model.getCards()) {
            card.addActionListener(this);
        }
    }

    /**
     * Method to handle user interactions when cards are being clicked
     *
     * @param e the action event associated with a card click
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Card currentCard = (Card) e.getSource();
        // Makes sure that only cards that haven't been matched or is currently clicked can be chosen
        if (!currentCard.isMatched() && !cardsBeingProcessed) {
            if (chosenCard == null) {
                chosenCard = currentCard;
                chosenCard.showCard(); // Shows the card clicked
            } else if (chosenCard == currentCard) { // Turn card if clicking the same one twice
                chosenCard.hideCard();
                chosenCard = null;
            } else {
                cardsBeingProcessed = true;  // Set to true to indicate that card are being processed

                Card secondCard = currentCard;
                currentCard.showCard(); // Shows the next card

                // Get values before starting the timer
                int chosenCardValue = chosenCard.getValue();
                int secondCardValue = secondCard.getValue();

                // Sets a new action listener with a 1 second timer
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Use the captured values instead of accessing chosenCard directly
                        if (chosenCardValue != secondCardValue) { // Hides the cards if not a match
                            chosenCard.hideCard();
                            secondCard.hideCard();
                            streak = 1;  // Resets a streak if cards don't match
                        } else { // Otherwise its a match
                            chosenCard.setCardMatch(true);
                            currentCard.setCardMatch(true);
                            model.setScore(streak);
                            streak *= 2;  // Increase streak by a factor of 2 for each streak
                        }
                        view.updateScore(model.getScore()); // Update the score shown

                        if (model.isWon()) { // If the game is won, call method to show dialog
                            view.showGameWon();
                        }

                        chosenCard = null;
                        cardsBeingProcessed = false;  // Reset to false after processing is complete
                    }
                });

                timer.setRepeats(false);
                timer.start();
            }
        }
    }
}


