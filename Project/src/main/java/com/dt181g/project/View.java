package com.dt181g.project;

import javax.swing.*;

/**
 * The View class represents the GUI of the Flappy Bird game
 * by extending JFrame and containing a GamePanel used to render the game elements
 * @author Andreas Backman
 */
public class View extends JFrame {
    private GamePanel gamePanel;

    /**
     * Constructor to create a View object that sets the title, defult close operation and size of the frame
     * It then initializes the GamePanel
     */
    public View() {
        setTitle("Flappy Bird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        gamePanel = new GamePanel();
        setVisible(true);
    }

    /**
     * Method to repaint the GamePanel to update the graphics
     */
    public void repaint() {
        gamePanel.repaint();
    }


}
