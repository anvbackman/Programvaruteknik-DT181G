package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    private JButton quitButton;
    private JButton startButton;

    public ButtonPanel() {
//        startButton = new JButton();
//        quitButton = new JButton();
        setLayout(new FlowLayout()); // Use FlowLayout for simplicity

        startButton = new JButton("Start");
        quitButton = new JButton("Quit");

        add(startButton);
        add(quitButton);
    }
    public void setQuitButton(ActionListener listener) {
        quitButton.addActionListener(listener);
    }

    public void setStartButton(ActionListener listener) {
        startButton.addActionListener(listener);
    }
}
