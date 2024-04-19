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

    private int score;
    private Card[] cards;

    public Model() {
        score = 0;
        cards = new Card[16];
        // Initialize cards with pairs of numbers from 1 to 8
        for (int i = 0; i < 8; i++) {
            cards[i * 2] = new Card(i + 1);
            cards[i * 2 + 1] = new Card(i + 1);
        }
        // Shuffle cards
        for (int i = 0; i < cards.length; i++) {
            int j = (int) (Math.random() * cards.length);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public Card getCard(int index) {
        return cards[index];
    }
}
