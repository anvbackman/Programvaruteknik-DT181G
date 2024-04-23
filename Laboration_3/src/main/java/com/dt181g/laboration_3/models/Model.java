package com.dt181g.laboration_3.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * The Model class represents the data of the Memory game and manages logic such as the cards and the score
 *  @author Andreas Backman
 */
public class Model {
    private int score;
    private final int amountOfCards;
    private Card[] cards;

    /**
     * Constructor for the Model class
     * Initializes the score and creates the cards for the game
     */
    public Model() {
        score = 0;
        amountOfCards = 16;
        cards = new Card[amountOfCards];

        // Initialize cards with pairs
        Integer[] indices = new Integer[amountOfCards / 2]; // Create an array of indices
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        Stream.of(indices).forEach(i -> { // For each index in the indices array
            cards[i * 2] = new Card(i + 1); // Create the first card of the pair
            cards[i * 2 + 1] = new Card(i + 1); // Create the second card of the pair
        });

        // Shuffles the cards
        List<Card> cardList = Arrays.asList(cards);
        Collections.shuffle(cardList);
        cards = cardList.toArray(new Card[0]);
    }

    /**
     * Method to get the score
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Method to increment the score
     */
    public void incrementScore() {
        score++;
    }

    /**
     * Method to get a card from the cards array
     * @param index the index of the card
     * @return the card
     */
    public Card getCard(int index) {
        return cards[index];
    }

    /**
     * Method to get the amount of cards
     * @return the amount of cards
     */
    public int getAmountOfCards() {
        return cards.length;
    }

    /**
     * Method to check if the game is won
     * @return true if all cards are face up, false otherwise
     */
    public boolean isGameWon() {
        return Arrays.stream(cards).allMatch(Card::isFaceUp);
    }
}
