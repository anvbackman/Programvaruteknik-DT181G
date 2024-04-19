package com.dt181g.laboration_3.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The View class represents the view of the Memory game and manages the GUI components such as buttons and labels
 *  @author Andreas Backman
 */
public class View extends JFrame {
    private final JLabel scoreLabel;
    private final JButton[] cardButtons;
    private final JLabel instructionsLabel;

    /**
     * Constructor for the View class
     * Initializes the GUI components such as buttons and labels
     */
    public View(int amountOfCards) {
        setTitle("Memory");
        scoreLabel = new JLabel("Score: 0");
        cardButtons = new JButton[amountOfCards];
        JPanel gridPanel = new JPanel(new GridLayout(4, 4, 5, 5));

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
        JButton instructionsButton = new JButton("Instructions");
        instructionsLabel = new JLabel("Instructions");
        add(instructionsButton, BorderLayout.SOUTH);
        showInstructions();
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInstructions();
            }
        });
    }

    /**
     * Method to set the score label
     * @param score the score to set
     */
    public void setScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    /**
     * Method to set the text of a card button
     * @param index the index of the card button
     * @param text the text
     */
    public void setCardText(int index, String text) {
        cardButtons[index].setText(text);
    }

    /**
     * Method to add an action listener to a card button
     * @param index the index of the card button
     * @param listener the action listener
     */
    public void addCardActionListener(int index, ActionListener listener) {
        cardButtons[index].addActionListener(listener);
    }

    /**
     * Method to get a card button
     * @param index the index of the card button
     * @return the card button
     */
    public JButton getCardButton(int index) {
        return cardButtons[index];
    }

    /**
     * Method to show the instructions for the game
     */
    private void showInstructions() {
        JOptionPane.showMessageDialog(instructionsLabel, "Welcome to Memory! \nIn this game you will try to match numbers with each other by clicking on the cards showing.\n" +
                "If you get a matching pair, your score will increase by 1 and if the cards doesn't match they will flip back into hiding.\nIf you how ever get multiple matches in a row, the amount is received is multiplied by 2." +
                " On your second match in a row you will get 2 points added to the score.\nOn your third match in a row you will get 4 points added to the score and so on. \n" +
                "If you break your streak you will receive 1 point on your next match. Your game will be completed when all cards are turned.");
    }
}