package com.dt181g.laboration_2;



import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class Manager implements ActionListener {

    private JLabel producerLabel;
    private JLabel consumerLabel;
    private ResourcePool resourcePool;

    private int startingProducers = 6;
    private int startingConsumers = 5;
    private Deque<Producer> activeProducers;
    private Deque<Consumer> activeConsumers;

    public Manager(ResourcePool resourcePool, JLabel producerLabel, JLabel consumerLabel) {
        this.resourcePool = resourcePool;
        this.producerLabel = producerLabel;
        this.consumerLabel = consumerLabel;

        this.activeProducers = new LinkedList<>();
        this.activeConsumers = new LinkedList<>();

    }

    public void startSimulation() {
        Timer timer = new Timer(150, this);
        timer.start();

        for (int i = 0; i < startingProducers; i++) {
            Producer producer = new Producer(resourcePool);
            activeProducers.add(producer);
            new Thread(producer).start();
        }
        for (int i = 0; i < startingConsumers; i++) {
            Consumer consumer = new Consumer(resourcePool);
            activeConsumers.add(consumer);
            new Thread(consumer).start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            adjust();

        });
    }

    private void adjust() {

        int availableResources = resourcePool.getResourceAmount();

        if (availableResources > 75) {
            increaseConsumers();
            decreaseProducers();
        } else if (availableResources < 45) {
            increaseProducers();
            decreaseConsumers();
        }
        updateGUI();
    }



    private void increaseProducers() {

        Producer producer = new Producer(resourcePool);
        activeProducers.add(producer);
        new Thread(producer).start();


//        if (!activeProducers.isEmpty()) {
//            Producer producer = activeProducers.pollFirst();
//            new Thread(producer).start();
//        }
    }

    private void decreaseProducers() {

        if (!activeProducers.isEmpty()) {
            activeProducers.getLast().stop();
            activeProducers.removeLast();
        }
//        if (!activeProducers.isEmpty()) {
//            Producer producer = activeProducers.pollLast();
//            producer.stop();
//        }
    }

    private void increaseConsumers() {

        Consumer consumer = new Consumer(resourcePool);
        activeConsumers.add(consumer);
        new Thread(consumer).start();
//        Consumer consumer = new Consumer(resourcePool);
//        activeConsumers.add(consumer);
//        new Thread(consumer).start();
    }

    private void decreaseConsumers() {

        if (!activeConsumers.isEmpty()) {
            activeConsumers.getLast().stop();
            activeConsumers.removeLast();
        }
//        if (!activeConsumers.isEmpty()) {
//            Consumer consumer = activeConsumers.pollLast();
//            consumer.stop();
//        }
    }

    private void updateGUI() {
        SwingUtilities.invokeLater(() -> {
            producerLabel.setText("Producers: " + (activeProducers.size()));
            consumerLabel.setText("Consumers: " + (activeConsumers.size()));
        });
    }
}




