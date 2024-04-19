package com.dt181g.laboration_3.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JLabel scoreLabel;
    private JPanel gridPanel;
    private JButton[] cardButtons;
    private JLabel instructionsLabel;
    private JButton instructionsButton;

    public View() {
        setTitle("Memory");
        scoreLabel = new JLabel("Score: 0");
        cardButtons = new JButton[16];
        gridPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        for (int i = 0; i < cardButtons.length; i++) {
            cardButtons[i] = new JButton("");
            gridPanel.add(cardButtons[i]);
        }
        add(scoreLabel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Label to show the instructions of the game
        instructionsButton = new JButton("Instructions");
        instructionsLabel = new JLabel("Instructions");
        add(instructionsButton, BorderLayout.SOUTH);
        showInstructions();
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                showInstructions();
            }
        });
        // Starts the welcome message dialog containing instructions about the game

    }

    public void setScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void setCardText(int index, String text) {
        cardButtons[index].setText(text);
    }

    public void addCardActionListener(int index, ActionListener listener) {
        cardButtons[index].addActionListener(listener);
    }

    public JButton getCardButton(int index) {
        return cardButtons[index];
    }

    private void showInstructions() {
        JOptionPane.showMessageDialog(instructionsLabel, "Welcome to Memory! \nIn this game you will try to match numbers with each other by clicking on the cards showing.\n" +
                "If you get a matching pair, your score will increase by 1 and if the cards doesn't match they will flip back into hiding.\nIf you how ever get multiple matches in a row, the amount is received is multiplied by 2." +
                " On your second match in a row you will get 2 points added to the score.\nOn your third match in a row you will get 4 points added to the score and so on. \n" +
                "If you break your streak you will receive 1 point on your next match. Your game will be completed when all cards are turned.");
    }
}