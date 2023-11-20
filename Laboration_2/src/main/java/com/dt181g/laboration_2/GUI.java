package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {

    private Color color;
    private ResourcePool resourcePool;

    public GUI(ResourcePool resourcePool) {
        this.color = Color.BLUE;
        this.resourcePool = resourcePool;
        resourcePool.setGUI(this);

        JFrame frame = new JFrame("Producer / Consumer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel producerLabel = new JLabel("Producers: 0");
        JLabel consumerLabel = new JLabel("Consumers: 0");

        frame.add(producerLabel, BorderLayout.WEST);
        frame.add(consumerLabel, BorderLayout.EAST);
        frame.add(this, BorderLayout.CENTER);

        Manager manager = new Manager(resourcePool, producerLabel, consumerLabel);
        manager.startSimulation();

        frame.setSize(800, 800);
        frame.setVisible(true);
    }


    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

//        int diameter = Math.min(getWidth(), getHeight());
//        int ovalDiameter = (int) (diameter * 0.5);
//        int x = (getWidth() - ovalDiameter) / 2;
//        int y = (getHeight() - ovalDiameter) / 2;

        int x = (getWidth() / 2) - (resourcePool.getResourceAmount() / 2);
        int y = (getHeight() / 2) - (resourcePool.getResourceAmount() / 2);



        g.setColor(color);
        g.fillOval(x, y, resourcePool.getResourceAmount(), resourcePool.getResourceAmount());
    }
}
