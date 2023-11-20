package com.dt181g.laboration_2;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Manager implements ActionListener {

    private JLabel producerLabel;
    private JLabel consumerLabel;
    private ResourcePool resourcePool;
    private int numProducers;
    private int numConsumers;

    public Manager(ResourcePool resourcePool, JLabel producerLabel, JLabel consumerLabel) {
        this.resourcePool = resourcePool;
        this.producerLabel = producerLabel;
        this.consumerLabel = consumerLabel;
        this.numProducers = 6;
        this.numConsumers = 5;
//
//        startProducers();
//        startConsumers();


    }

    public void startSimulation() {
        Timer timer = new Timer(150, this);
        timer.start();

        for (int i = 0; i < numProducers; i++) {
            new Thread(new Producer(resourcePool)).start();
        }
        for (int i = 0; i < numConsumers; i++) {
            new Thread(new Consumer(resourcePool)).start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            adjust();
            updateGUI();
//            checkForUserIntervention();
        });
    }

    private void adjust() {
        int availableResources = resourcePool.getResourceAmount();

        if (availableResources < 50) {
            numProducers++;
            numConsumers--;
            System.out.println("Adjustment: More Producers, Fewer Consumers");
        } else if (availableResources >= 150) {
            numProducers--;
            numConsumers++;
            System.out.println("Adjustment: Fewer Producers, More Consumers");
        }
    }

    private void updateGUI() {
        SwingUtilities.invokeLater(() -> {
            producerLabel.setText("Producers: " + numProducers);
            consumerLabel.setText("Consumers: " + numConsumers);
        });

    }

}




