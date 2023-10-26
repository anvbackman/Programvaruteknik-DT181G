package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    public Renderer renderer;
    public GUI() {

        Timer timer = new Timer(20, this);
        renderer = new Renderer();
        JFrame frame = new JFrame();
        frame.add(renderer);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        renderer.repaint();
    }

}
