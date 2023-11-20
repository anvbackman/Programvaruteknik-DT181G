package com.dt181g.laboration_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {

    private List<Card> cards;
    private Card firstCard;
    private Card secondCard;
    private int score;
    private int highScore;

    private String instructions;

    public Model() {
        cards = new ArrayList<>();
        showCards();
        this.score = 0;

        instructions = "Clickety";
    }

    private void showCards() {

        for (int i = 1; i <= 8; i++) {
            cards.add(new Card(i));
            cards.add(new Card(i));
        }
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void selectCards(Card card) {
        if (firstCard == null) {
            firstCard = card;
        }
        else if (secondCard == null) {
            secondCard = card;
            checkMatch();
        }
    }

    private void checkMatch() {
        if (firstCard.getValue() == secondCard.getValue()) {
            firstCard.setCardMatch(true);
            secondCard.setCardMatch(true);
        }
        firstCard = null;
        secondCard = null;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int amount) {
        score += amount;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int amount) {
        highScore = score;
    }

    public String getInstructions() {
        return instructions;
    }


}
