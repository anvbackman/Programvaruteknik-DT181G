package com.dt181g.laboration_3.controllers;

import com.dt181g.laboration_3.models.Card;
import com.dt181g.laboration_3.models.Model;
import com.dt181g.laboration_3.views.CardView;
import com.dt181g.laboration_3.views.View;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * The Controller class that handles user interactions an update the model and view classes based on it
 *
 * @author Andreas Backman
 */
public class Controller implements ActionListener {

    private Model model;
    private View view;
    private Card cardValue;
    private Deque<CardView> selectedCards = new ArrayDeque<>();
    private CardView secondCard;

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


    private static List<Color> generateRandomColors() {
        List<Color> colors = new ArrayList<>();

        // Add eight distinct colors to the list
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.YELLOW);
        colors.add(Color.CYAN);
        colors.add(Color.MAGENTA);
        colors.add(Color.ORANGE);
        colors.add(Color.PINK);

        // Shuffle the list to randomize the order of colors
        Collections.shuffle(colors);

        return colors;
    }

//    private void cardClicked(CardView cardView, Card card) {
//        if (!card.isMatched() && !cardView.isShowing()) {
//            cardView.showCard(card.getValue());
////            cardView.hideCard();
//
//            if (chosenCard == null) {
////                chosenCard = card.getValue();
//                chosenCardView = cardView;
////                System.out.println(card.getValue());
////                System.out.println(Integer.parseInt(chosenCardView.getText()));
//            } else {
//                secondCardView = cardView;
////                System.out.println(card.getValue());
////                System.out.println(Integer.parseInt(secondCardView.getText()));
//
//            }
//
//
//
//
//        }
//    }

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
        Card clickedCard = cardMap.get(currentCard);


        if (!clickedCard.isMatched() && !currentCard.isShowing()) {
            currentCard.showCard(clickedCard.getValue());
            selectedCards.add(currentCard);

            if (selectedCards.size() == 2) {

                for (CardView cardView : selectedCards) {
                    System.out.println(cardView);
                }
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                        processSelectedCards();
                        CardView firstCard = selectedCards.poll();
                        CardView secondCard = selectedCards.poll();

                        String firstCardValue = firstCard.getText();
                        String secondCardValue = secondCard.getText();

                        if (!firstCardValue.equals(secondCardValue)) {
                            Timer timer = new Timer(1000, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("No match");
                                    currentCard.setText("");
                                    selectedCards.remove(currentCard);


//                    firstCard.setText("");
//                    secondCard.setText("");


//                    firstCard.hideCard();
//                    secondCard.hideCard();

//                    firstCard.setText("11");
//                    secondCard.setText("11");


                                    System.out.println("Here are selectedCards: " + selectedCards);

//                    chosenCard = null;


                                }

                            });
                            timer.setRepeats(false);
                            timer.start();
                        }
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

//    private void processSelectedCards() {
//        CardView firstCard = selectedCards.poll();
//        CardView secondCard = selectedCards.poll();
//
//        String firstCardValue = firstCard.getText();
//        String secondCardValue = secondCard.getText();
//
//        System.out.println("First: " + firstCardValue + " Second: " + secondCardValue);

//        if (!firstCardValue.equals(secondCardValue)) {
//            Timer timer = new Timer(1000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    System.out.println("No match");
//
//
//
////                    firstCard.setText("");
////                    secondCard.setText("");
//
//
////                    firstCard.hideCard();
////                    secondCard.hideCard();
//
////                    firstCard.setText("11");
////                    secondCard.setText("11");
//
//
//
//                    System.out.println("Here are selectedCards: " + selectedCards);
//
////                    chosenCard = null;
//
//
//                }
//
////            });
//            timer.setRepeats(false);
//            timer.start();
//        }
//
//        else {
//            selectedCards.clear();
//
//        }
////        else {
//////            firstCard.setText("");
//////            secondCard.setText("");
////
////        }
//
//
//
//    }

    public void restoreCard() {

    }


//        cardView.showCard(Integer.valueOf(1));
//        cardView.setText("2");

//
//
//
//
//        if (!clickedCard.isMatched() && !cardsBeingProcessed) {
//            if (chosenCard == null) {
//                chosenCard = currentCard;
////                cardClicked(chosenCard, clickedCard);
//                cardView.showCard(clickedCard.getValue());
//
////                System.out.println("Chosen card = " + chosenCard.getCardValue() + " clicked = " + clickedCard.getValue());
//
//            }
//            else if (chosenCard == currentCard) { // Turn card if clicking the same one twice
//                chosenCard.setText("X");
//                chosenCard = null;
//            }
//
//            else {
//
//
//                cardsBeingProcessed = true;
//
//                CardView secondCard =  currentCard;
//
//                cardClicked(currentCard, clickedCard);
//                Card secondClickedCard = cardMap.get(secondCard);
//
////                int chosenCardValue = chosenCard.getCardValue();
////                int secondCardValue = secondCard.getCardValue();
//
////                System.out.println("chosen" + chosenCardValue);
////                System.out.println("second" + secondCardValue);
//
////                secondCardView.showCard(secondClickedCard.getValue());
//
//
//                Timer timer = new Timer(1000, new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//
////                        if (chosenCardValue != secondCardValue) {
////                            chosenCard.setText("X");
//////                            System.out.println("No match");
////                            secondCard.setText("X");
////                            streak = 1;
////                        }
//
////                        else {
////                            clickedCard.setCardMatch(true);
////                            secondClickedCard.setCardMatch(true);
////                            model.setScore(streak);
////                            streak *= 2;
////                        }
//                        view.updateScore(model.getScore());
//
//                        if (model.isWon()) {
//                            view.showGameWon();
//                        }
//
//
//                        chosenCard = null;
//                        cardsBeingProcessed = false;
//
//                    }
//
//                });
//                timer.setRepeats(false);
//                timer.start();


                //            if (chosenCardValue != secondCardValue) {
                //                chosenCard.hideCard();
                //                secondCard.hideCard();
                //                System.out.println("NOT");
                //            }

//            }
//            else if (chosenCard == currentCard) {
//                chosenCard.hideCard();
//                chosenCard = null;
//            }

//        }




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