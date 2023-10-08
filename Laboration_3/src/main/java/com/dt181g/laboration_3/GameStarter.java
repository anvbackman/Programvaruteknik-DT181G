package com.dt181g.laboration_3;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class GameStarter {

    public static void startGame(JFrame parentFrame, JTextField numberOfCards) {
        String inputText = numberOfCards.getText().trim();
        System.out.println("Input text = " + inputText);
        if (!inputText.isEmpty()) { // Check if the input is not empty
            try {
                int numberOfPairs = Integer.parseInt(inputText);
                if (numberOfPairs % 2 == 0 && numberOfPairs > 0) {
                    ImageLoader imageLoader = new ImageLoader();

                    List<BufferedImage> images = imageLoader.loadImage("../IMG", numberOfPairs);
                    Model model = new Model(images);
                    View view = new View(model.getCards());
                    Controller controller = new Controller(model, view);

                    parentFrame.getContentPane().removeAll();
                    parentFrame.getContentPane().add(view);
                    parentFrame.pack();
                    parentFrame.setVisible(true);
                } else {
                    System.out.println("Please enter a positive even number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        } else {
            System.out.println("Please enter a number.");
        }
    }
}
