package com.dt181g.project.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * ButtonPanel class represents the buttons used in the FlappyBird game
 * @author Andreas Backman
 */
public class ButtonPanel extends JPanel {
    private final JButton quitButton;
    private final JButton infoButton;

    /**
     * Constructor that takes action listeners as parameter and then configures the buttons
     * @param infoActionListener the action listener for the Game Info button
     * @param quitActionListener the action listener for the Quit button
     */
    public ButtonPanel(ActionListener infoActionListener, ActionListener quitActionListener) {
        // Sets button layout
        setLayout(new FlowLayout());
        Dimension size = new Dimension(200, 50);

        // Creates buttons for info and quitting, adds it to the panel, setFocusable to not be focused by space bar
        // Then adds the ActionListener to the button
        infoButton = new JButton("Game Info");
        add(infoButton);
        infoButton.setPreferredSize(size);
        infoButton.setFocusable(false);
        infoButton.addActionListener(infoActionListener);

        quitButton = new JButton("Quit");
        add(quitButton);
        quitButton.setPreferredSize(size);
        quitButton.setFocusable(false);
        quitButton.addActionListener(quitActionListener);
    }
}

