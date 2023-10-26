package com.dt181g.project;

import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {

    public static final long serialVersionUID = 1L; // ????

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        FlappyBird.flappyBird.repaint(g);
    }
}
