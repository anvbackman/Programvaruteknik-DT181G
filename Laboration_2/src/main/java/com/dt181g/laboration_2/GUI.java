package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.*;

/**
 * The GUI class represents the Graphical User Interface for the Producer/Consumer simulation
 * By extending JPanel it can create a custom GUI component
 *
 * @author Andreas Backman
 */
public class GUI extends JPanel {

    private Color color;
    private ResourcePool resourcePool;

    /**
     * Constructor that constructs a GUI with the specified resource pool
     *
     * @param resourcePool the resource pool to be associated with the GUI
     */
    public GUI(ResourcePool resourcePool) {
        this.color = Color.BLUE;
        this.resourcePool = resourcePool;

        // Set this GUI as the visualizer
        resourcePool.setGUI(this);

        // Create the main JFrame
        JFrame frame = new JFrame("Producer / Consumer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels used to show the active producers / consumers
        JLabel producerLabel = new JLabel("Producers: 0");
        JLabel consumerLabel = new JLabel("Consumers: 0");
        producerLabel.setForeground(Color.GREEN);
        consumerLabel.setForeground(Color.RED);

        // Adds the labels to the frame
        frame.add(producerLabel, BorderLayout.WEST);
        frame.add(consumerLabel, BorderLayout.EAST);
        frame.add(this, BorderLayout.CENTER);

        // Creates a manager object to start the simulation
        Manager manager = new Manager(resourcePool, producerLabel, consumerLabel);
        manager.startSimulation();

        // Sets the color and size and change the visibility of the frame
        frame.getContentPane().setBackground(Color.BLACK);
        this.setBackground(Color.BLACK);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    /**
     * Method to set the color of the oval and triggers repaint
     *
     * @param color the color of the oval
     */
    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    /**
     * Method to draw the oval representing the resource pool
     *
     * @param g the graphics used for painting
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Calculating the position of the oval
        int x = (getWidth() / 2) - (resourcePool.getResourceAmount() / 2);
        int y = (getHeight() / 2) - (resourcePool.getResourceAmount() / 2);

        // Sets the color of the oval and fills it
        g.setColor(color);
        g.fillOval(x, y, resourcePool.getResourceAmount(), resourcePool.getResourceAmount());
    }
}
