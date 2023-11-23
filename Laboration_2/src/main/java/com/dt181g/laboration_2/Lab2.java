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
            ResourcePool resourcePool = new ResourcePool(50);
            GUI gui = new GUI(resourcePool);
<<<<<<< HEAD

<<<<<<< HEAD
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Producer / Consumer");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            JLabel producerLabel = new JLabel("Producers: 0");
//            JLabel consumerLabel = new JLabel("Consumers: 0");
//
//
//
//
//            ResourcePool resourcePool = new ResourcePool(50);
//            GUI gui = new GUI(resourcePool);
//
//            frame.add(producerLabel, BorderLayout.WEST);
//            frame.add(consumerLabel, BorderLayout.EAST);
//            frame.add(gui, BorderLayout.CENTER);
//
//            Manager manager = new Manager(resourcePool, producerLabel, consumerLabel);
//
//            manager.startSimulation();
//
//            frame.setSize(800, 800);
//            frame.setVisible(true);
=======

        JLabel producerLabel = new JLabel("Producers: 6");
        JLabel consumerLabel = new JLabel("Consumers: 5");

>>>>>>> laboration_3

        });

<<<<<<< HEAD
=======
        JFrame frame = new JFrame("Resource Pool Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);



        Manager manager = new Manager();

        frame.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        JPanel center = new JPanel();
        JPanel bottom = new JPanel();


        center.add(producerLabel);
        bottom.add(consumerLabel);

        frame.getContentPane().setBackground(Color.BLACK);

        center.setPreferredSize(new Dimension(800, 100));
        bottom.setPreferredSize(new Dimension(800, 200));


        ResourcePanel resourcePanel = new ResourcePanel(resourcePool);
        resourcePanel.setPreferredSize(new Dimension(800, 200));




//        frame.add(top, BorderLayout.NORTH);
        frame.add(center, BorderLayout.EAST);
        frame.add(bottom, BorderLayout.WEST);
        frame.add(resourcePanel, BorderLayout.CENTER);



        frame.pack();
        frame.setVisible(true);


        manager.startAdjustmentTimer();
>>>>>>> laboration_3
=======
        });
>>>>>>> laboration_2
    }
}
