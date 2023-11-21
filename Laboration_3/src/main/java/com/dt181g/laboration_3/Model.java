package com.dt181g.laboration_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Model {

    private List<Card> cards;
    private Card firstCard;
    private Card secondCard;
    private int score;
    private int highScore;

    public Model() {
        cards = generateCards();
        this.score = 0;

    }

    private List<Card> generateCards() {
        List<Card> cardList = IntStream.rangeClosed(1, 8).boxed().flatMap(i -> List.of(new Card(i), new Card(i)).stream())
                .collect(Collectors.toList());

        Collections.shuffle(cardList);
        return cardList;
    }

    public List<Card> getCards() {
        return cards;
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

}
