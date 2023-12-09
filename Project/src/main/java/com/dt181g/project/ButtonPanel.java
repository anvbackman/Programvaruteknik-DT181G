package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    private JButton quitButton;
    private JButton startButton;

    public ButtonPanel(ActionListener quitActionListener) {
        setLayout(new FlowLayout());

//        startButton = new JButton("RESTART");
//        add(startButton);
//
//        // Add the provided ActionListener for the startButton
//        startButton.addActionListener(startActionListener);

        quitButton = new JButton("Quit");
        add(quitButton);

        quitButton.setFocusable(false);

        // Add the provided ActionListener for the quitButton
        quitButton.addActionListener(quitActionListener);

    }

//    public ButtonPanel() {
//
//        setLayout(new FlowLayout());
//
//        startButton = new JButton("Start");
//        quitButton = new JButton("Quit");
//        add(startButton);
//        add(quitButton);
//
//        // Add ActionListener for the quitButton
//        quitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Quitting the program...");
//                System.exit(0);
//            }
//        });
//
//    }
    public void setQuitButton(ActionListener listener) {
        System.out.println("quitButton set");
        quitButton.addActionListener(listener);
    }

    public void setStartButton(ActionListener listener) {
        this.startButton.addActionListener(listener);
    }

    public void setButtonVisible(boolean state) {
        startButton.setVisible(state);
        quitButton.setVisible(state);
    }
}
