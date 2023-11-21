package com.dt181g.laboration_3.models;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The Model class represents the data of the Memory game and manages logic such as the cards and the score
 *
 * @author Andreas Backman
 */
public class Model {

    private List<Card> cards;
    private int score;

    /**
     * Constructor that initializes the list of cars and setts the score to 0
     */
    public Model() {
        cards = generateCards();
        this.score = 0;
    }

    /**
     * Method that generates the amount of cards to be used, shuffels them and then returns the list containing the cards
     *
     * @return the shuffeled list of cards
     */
    private List<Card> generateCards() {
        // Generates a stream of integers from 1 to 8
        List<Card> cardList = IntStream.rangeClosed(1, 8).boxed()
                // For each integer, create a list with two cards with the value i
                .flatMap(i -> List.of(new Card(i), new Card(i)).stream())
                // Then collect the cards into a list
                .collect(Collectors.toList());

        // Shuffles and returns the list
        Collections.shuffle(cardList);
        return cardList;
    }

    /**
     * Method to retrieve the cards
     *
     * @return the list of cards
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Method to retrieve the score
     *
     * @return the current score
     */
    public int getScore() {
        return score;
    }

    /**
     * Method to set the score
     *
     * @param amount the amount to increase the score by
     */
    public void setScore(int amount) {
        score += amount;
    }

    /**
     * Method to check if all cards has been matched
     *
     * @return true if all cards has been match, otherwise false.
     */
    public boolean isWon() {
        // Converts the list to a stream and checks if all cards in that stream are matched
        return cards.stream().allMatch(Card::isMatched);
    }

}
