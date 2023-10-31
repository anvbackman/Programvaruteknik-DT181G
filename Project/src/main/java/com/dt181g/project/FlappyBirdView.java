package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FlappyBirdView extends JPanel {
    private FlappyBirdModel model;

    public FlappyBirdView(FlappyBirdModel model) {
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw bird
        g.setColor(Color.RED);
        g.fillRect(50, model.getBirdY(), 50, 50);

        // Draw pipes
        g.setColor(Color.GREEN);
        List<Integer> pipeXPositions = model.getPipeXPositions();
        for (int pipeX : pipeXPositions) {
            g.fillRect(pipeX, 0, 50, 200);
            g.fillRect(pipeX, 350, 50, 200);
        }
    }
}
