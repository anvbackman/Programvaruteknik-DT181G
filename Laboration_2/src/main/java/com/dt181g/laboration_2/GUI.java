package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {

    private Color color;

    public GUI() {
        this.color = Color.BLUE;
    }


    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
}
