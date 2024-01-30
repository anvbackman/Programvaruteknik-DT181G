package com.dt181g.laboration_3.controllers;

import com.dt181g.laboration_3.models.Card;
import com.dt181g.laboration_3.models.Model;
import com.dt181g.laboration_3.views.CardView;
import com.dt181g.laboration_3.views.View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Controller class that handles user interactions an update the model and view classes based on it
 *
 * @author Andreas Backman
 */
public class Controller implements ActionListener {

    private Model model;
    private View view;
    private Card cardValue;
    private CardView chosenCard;
    private CardView chosenCardView;
    private CardView secondCardView;
    private boolean cardsBeingProcessed = false;
    private int score;
    private int streak = 1;
    private CardView cardView;
    private List<CardView> cardViewList;
    private Map<CardView, Card> cardMap;

    /**
     * Constructor that takes the model and view as parameters. It then set the score to 0 and adds an action
     * listener to each card
     *

     */
    public Controller() {
        this.model = new Model();
//        this.view = new View();
        this.score = 0;
        cardView = new CardView();
        this.cardViewList = new ArrayList<>();

        cardMap = new HashMap<>();

        // Adds an action listener to each card in the model
        for (Card card : model.getCards()) {
            CardView cardButton = new CardView();
//            cardButton.addActionListener(e -> cardClicked(cardButton, card));
            cardButton.addActionListener(this);
            cardViewList.add(cardButton);

            cardMap.put(cardButton, card);
        }

        view = new View(cardViewList);


    }

    private void cardClicked(CardView cardView, Card card) {
        if (!card.isMatched() && !cardView.isShowing()) {
            cardView.showCard(card.getValue());
//            cardView.hideCard();

            if (chosenCard == null) {
//                chosenCard = card.getValue();
                chosenCardView = cardView;
                System.out.println(card.getValue());
//                System.out.println(Integer.parseInt(chosenCardView.getText()));
            } else {
                secondCardView = cardView;
                System.out.println(card.getValue());
//                System.out.println(Integer.parseInt(secondCardView.getText()));
            }




        }
    }

    public List<CardView> getCardViewList() {
        return cardViewList;
    }

    /**
     * Method to handle user interactions when cards are being clicked
     *
     * @param e the action event associated with a card click
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        CardView currentCard = (CardView) e.getSource();
        System.out.println("HÖ");

        Card clickedCard = cardMap.get(currentCard);

        cardClicked(currentCard, clickedCard);



        if (!clickedCard.isMatched() && !cardsBeingProcessed) {
            if (chosenCard == null) {
                chosenCard = currentCard;
                System.out.println("Chosen card = " + chosenCard.getCardValue() + " clicked = " + clickedCard.getValue());

            }
            else if (chosenCard == currentCard) { // Turn card if clicking the same one twice
                chosenCard.setText("");
                chosenCard = null;
            }

            else {


                cardsBeingProcessed = true;

                CardView secondCard =  currentCard;


                int chosenCardValue = chosenCard.getCardValue();
                int secondCardValue = secondCard.getCardValue();

                System.out.println("chosen" + chosenCardValue);
                System.out.println("second" + secondCardValue);


                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (chosenCardValue != secondCardValue) {
                            chosenCardView.setText("");
//                            System.out.println("No match");
                            secondCardView.setText("");
                        }

                        else {
                            clickedCard.setCardMatch(true);
                        }


                        chosenCard = null;
                        cardsBeingProcessed = false;

                    }

                });
                timer.setRepeats(false);
                timer.start();


                //            if (chosenCardValue != secondCardValue) {
                //                chosenCard.hideCard();
                //                secondCard.hideCard();
                //                System.out.println("NOT");
                //            }

            }
//            else if (chosenCard == currentCard) {
//                chosenCard.hideCard();
//                chosenCard = null;
//            }

        }




//        if (!currentCard.isMatched() && !cardsBeingProcessed) {
//            if (chosenCard == null) {
//                chosenCard = currentCard;
////                chosenCard.showCard(); // Shows the card clicked
//            } else if (chosenCard == currentCard) { // Turn card if clicking the same one twice
//                chosenCard.hideCard();
//                chosenCard = null;
//            } else {
//                cardsBeingProcessed = true;  // Set to true to indicate that card are being processed
//
//                Card secondCard = currentCard;
//                currentCard.showCard(); // Shows the next card
//
//                // Get values before starting the timer
//                int chosenCardValue = chosenCard.getValue();
//                int secondCardValue = secondCard.getValue();




//            chosenCard.showCard(cardValue.getValue());

//        // Makes sure that only cards that haven't been matched or is currently clicked can be chosen
//        if (!currentCard.isMatched() && !cardsBeingProcessed) {
//
//            if (chosenCard == null) {
//                chosenCard = currentCard;
////                chosenCard.showCard(); // Shows the card clicked
//            } else if (chosenCard == currentCard) { // Turn card if clicking the same one twice
////                chosenCard.hideCard();
//                chosenCard = null;
//            } else {
//                cardsBeingProcessed = true;  // Set to true to indicate that card are being processed
//
//                Card secondCard = currentCard;
////                Card test = currentCard.getValue();
////                currentCard.showCard(); // Shows the next card
//
//                int chosenCardValue = chosenCard.getValue();
//                int secondCardValue = secondCard.getValue();
//
//
//
//
//
//
//
//                // Sets a new action listener with a 1 second timer
//                Timer timer = new Timer(1000, new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        // Use the captured values instead of accessing chosenCard directly
//                        if (!chosenCardView.equals(secondCardView)) { // Hides the cards if not a match
//                            System.out.println("Not");
//                            chosenCardView.hideCard();
//                            secondCardView.hideCard();
//
//                            streak = 1;  // Resets a streak if cards don't match
//                        } else { // Otherwise its a match
//                            System.out.println("Yis");
//
//                            chosenCard.setCardMatch(true);
//                            currentCard.setCardMatch(true);
//                            model.setScore(streak);
//
//                            streak *= 2;  // Increase streak by a factor of 2 for each streak
//                        }
//                        view.updateScore(model.getScore()); // Update the score shown
//
//
//                        if (model.isWon()) { // If the game is won, call method to show dialog
//                            view.showGameWon();
//                        }
//
//                        chosenCard = null;
//                        cardsBeingProcessed = false;  // Reset to false after processing is complete
//                    }
//                });
//                timer.setRepeats(false);
//                timer.start();
//            }
//        }

    }
}


