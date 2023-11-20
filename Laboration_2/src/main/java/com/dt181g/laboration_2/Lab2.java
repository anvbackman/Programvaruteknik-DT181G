package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


/**
 * The main starting point for laboration 2.
 * @author Erik Ström
 */
public final class Lab2 {
    private Lab2() { // Utility classes should not have a public or default constructor
        throw new IllegalStateException("Utility class");
    }

    /**
     * Simple output of the assignment's name. Be sure to replace
     * this when working with the assignment!
     * @param args command arguments.
     */
    public static void main(final String... args) throws InterruptedException {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Producer / Consumer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel producerLabel = new JLabel("Producers: 0");
            JLabel consumerLabel = new JLabel("Consumers: 0");

            GUI gui = new GUI();
            frame.add(producerLabel, BorderLayout.WEST);
            frame.add(consumerLabel, BorderLayout.EAST);
            frame.add(gui, BorderLayout.CENTER);

            ResourcePool resourcePool = new ResourcePool(50, gui);
            Manager manager = new Manager(resourcePool, producerLabel, consumerLabel);

            manager.startSimulation();

            frame.setSize(800, 800);
            frame.setVisible(true);

        });

    }

}
