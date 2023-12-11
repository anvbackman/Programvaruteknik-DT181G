package com.dt181g.laboration_3.views;

import com.dt181g.laboration_3.controllers.Controller;
import com.dt181g.laboration_3.models.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;


/**
 * The View class which represents the GUI of the Memory game and contains methods
 * that initializes the game and updates and displays the game.
 *
 * @author Andreas Backman
 */
public class View extends JPanel {

    private Controller controller;
    private JFrame frame;
    private List<Card> cardList;
    private JLabel scoreLabel;
    private JLabel instructionsLabel;
    private JLabel winningMessage;

    /**
     * The View constructor takes a list as a parameter, sets the layout of the game (how many columns)
     * and calls the initialize method
     *
     * @param cardList the list containing the cards
     */
    public View(List<Card> cardList) {
        this.cardList = cardList;
        setLayout(new GridLayout(4, 4));
        initialize();
    }

    /**
     * Method that sets the controller
     *
     * @param controller the controller
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Method that initializes the game by starting a frame, showing the cards and the labels needed.
     */
    private void initialize() {

        frame = new JFrame();

        // Iterates over the card list and add them
        for (Card card : cardList) {
            add(card);
        }


        frame.setTitle("Memory");
        // Label to show the current score
        scoreLabel = new JLabel("Score: 0");
        frame.add(scoreLabel, BorderLayout.NORTH);

        // Customizes the frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);

        // Label to show the instructions of the game
        instructionsLabel = new JLabel("Instructions");
        // Starts the welcome message dialog containing instructions about the game
        JOptionPane.showMessageDialog(instructionsLabel, "Welcome to Memory! \nIn this game you will try to match numbers with each other by clicking on the cards showing.\n" +
                "If you get a matching pair, your score will increase by 1 and if the cards doesn't match they will flip back into hiding.\nIf you how ever get multiple matches in a row, the amount is received is multiplied by 2." +
                " On your second match in a row you will get 2 points added to the score.\nOn your third match in a row you will get 4 points added to the score and so on. \n" +
                "If you break your streak you will receive 1 point on your next match. Your game will be completed when all cards are turned.");
    }

    /**
     * Method used to update the current score
     * @param score the score of the player
     */
    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    /**
     * Method used to show a dialog when all cards has been matched, to then start a new game when exited.
     */
    public void showGameWon() {
        winningMessage = new JLabel("You won! Exit the dialog window to start a new game.");

        // Show the option pane
        JOptionPane optionPane = new JOptionPane(winningMessage, JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_OPTION, null, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Game Complete");
        // Then add an action listener to initialize a new game when closed
        dialog.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                initialize();
            }
        });

        dialog.setVisible(true);
    }
}
