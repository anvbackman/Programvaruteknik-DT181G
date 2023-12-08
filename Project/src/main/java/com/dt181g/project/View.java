package com.dt181g.project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class View extends JFrame {

    private JFrame frame;
    private GamePanel gamePanel;
    private ButtonPanel buttonPanel;

    public View() {
        setTitle("Flappy Bird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);

        buttonPanel = new ButtonPanel();
        gamePanel = new GamePanel();



//        setLayout(new BorderLayout());
//        add(gamePanel);
//        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public void repaint() {
        gamePanel.repaint();
    }

    public JFrame getFrame() {
        return this;
    }
}
