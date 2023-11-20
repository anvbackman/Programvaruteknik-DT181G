package com.dt181g.laboration_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class View extends JPanel {

    private JFrame frame;
    private List<Card> cardList;
    private JLabel scoreLabel;
    private JLabel highScoreLabel;
    private JLabel instructionsLabel;
    private JButton okButton;

    public View(List<Card> cardList) {
        this.cardList = cardList;
        setLayout(new GridLayout(4, 4));
        initialize();
    }

    private void initialize() {

        frame = new JFrame();

        for (Card card : cardList) {
            add(card);
        }

        scoreLabel = new JLabel("Score: 0");
        frame.add(scoreLabel, BorderLayout.NORTH);

        highScoreLabel = new JLabel("High Score: 0");
        frame.add(highScoreLabel, BorderLayout.EAST);

        instructionsLabel = new JLabel("Instructions: Clickety");
//        frame.add(instructionsLabel, BorderLayout.SOUTH);
//
//        okButton = new JButton("OK");
//        okButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                instructionsLabel.setVisible(false);
//            }
//        });
//        instructionsLabel.add(okButton);




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);


        JOptionPane.showMessageDialog(instructionsLabel, "Welcome to Memory! \nIn this game you will try to match numbers with each other by clicking on the cards showing.\n" +
                "If you get a matching pair, your score will increase by 1 and if the cards doesn't match they will flip back into hiding.\nIf you how ever get multiple matches in a row, the amount is received is multiplied by 2." +
                " On your second match in a row you will get 2 points added to the score.\nOn your third match in a row you will get 4 points added to the score and so on. \n" +
                "If you break your streak you will receive 1 point on your next match. Your game will be completed when all cards are turned.");
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void updateHighScore(int highScore) {
        highScoreLabel.setText("High Score: " + highScore);
    }

    public void addInstructions(String instructions) {
        instructionsLabel.setText(instructions);
//        instructionsLabel.setVisible(true);
    }

}
