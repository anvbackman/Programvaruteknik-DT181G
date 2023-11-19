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
    public void main(final String... args) throws InterruptedException {




//        ResourcePool resourcePool = new ResourcePool(50);
//
//        // Ensure that the program continues running
//        JLabel producerLabel = new JLabel("Producers: 6");
//        JLabel consumerLabel = new JLabel("Consumers: 5");
//        JLabel resourceLabel = new JLabel("Resource Amount: " + resourcePool.getResourceAmount());
//
//
//        JFrame frame = new JFrame("Resource Pool Simulation");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 400);
//
//
//
//        Manager manager = new Manager(resourcePool, producerLabel, consumerLabel);
//
//        frame.setLayout(new BorderLayout());
//        JPanel top = new JPanel();
//        JPanel center = new JPanel();
//        JPanel bottom = new JPanel();
//
//        top.add(resourceLabel);
//        center.add(producerLabel);
//        bottom.add(consumerLabel);
//
//        frame.getContentPane().setBackground(Color.BLACK);
//        top.setPreferredSize(new Dimension(800, 100));
//        center.setPreferredSize(new Dimension(800, 100));
//        bottom.setPreferredSize(new Dimension(800, 200));
//
//
//        ResourcePanel resourcePanel = new ResourcePanel(resourcePool);
//        resourcePanel.setPreferredSize(new Dimension(800, 200));
//
//
//
//
//        frame.add(top, BorderLayout.NORTH);
//        frame.add(center, BorderLayout.EAST);
//        frame.add(bottom, BorderLayout.SOUTH);
//        frame.add(resourcePanel, BorderLayout.CENTER);
//
//
//
//        frame.pack();
//        frame.setVisible(true);
//
//
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                manager.adjust();
//            }
//        }, 0, 150); // Adjust the delay as needed
    }

}
