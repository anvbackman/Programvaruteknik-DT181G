package com.dt181g.laboration_3;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {

    private List<Card> cards;
    private Card firstCard;
    private Card secondCard;

    private int amountOfCards;


    public Model(List<BufferedImage> images) {
        showCards(images);
    }


    private void showCards(List<BufferedImage> images) {
        cards = new ArrayList<>();
        for (BufferedImage image : images) {
            cards.add(new Card(image));
            cards.add(new Card(image));
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

//    private void checkMatch() {
//        if (firstCard.getValue() == secondCard.getValue()) {
//            firstCard.setCardMatch(true);
//            secondCard.setCardMatch(true);
//        }
//        firstCard = null;
//        secondCard = null;
//    }

    public boolean checkMatch() {
        if (firstCard != null && secondCard != null) {
            BufferedImage img1 = firstCard.getImage();
            BufferedImage img2 = secondCard.getImage();

            if (img1 == img2) {
                firstCard.setCardMatch(true);
                secondCard.setCardMatch(true);
                return true;
            }
        }
        return false;
    }
}
