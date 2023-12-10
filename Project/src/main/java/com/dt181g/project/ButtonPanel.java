package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    private JButton quitButton;
    private JButton infoButton;

    public ButtonPanel(ActionListener infoActionListener, ActionListener quitActionListener) {
        setLayout(new FlowLayout());

        infoButton = new JButton("Game Info");
        add(infoButton);

        infoButton.setFocusable(false);

        // Add the provided ActionListener for the infoButton
        infoButton.addActionListener(infoActionListener);

        quitButton = new JButton("Quit");
        add(quitButton);

        quitButton.setFocusable(false);

        // Add the provided ActionListener for the quitButton
        quitButton.addActionListener(quitActionListener);

    }


    }

