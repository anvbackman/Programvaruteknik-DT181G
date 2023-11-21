package com.dt181g.laboration_2;



import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
<<<<<<< HEAD
import java.util.List;
=======
import java.util.Timer;
>>>>>>> laboration_3


public class Manager implements ActionListener {

    private JLabel producerLabel;
    private JLabel consumerLabel;
    private ResourcePool resourcePool;
<<<<<<< HEAD
//    private GUI gui;

    private int startingProducers = 6;
    private int startingConsumers = 5;
    private Deque<Producer> activeProducers;
    private Deque<Consumer> activeConsumers;

    private boolean isAdjusting = false;

    public Manager(ResourcePool resourcePool, JLabel producerLabel, JLabel consumerLabel) {
        this.resourcePool = resourcePool;
        this.producerLabel = producerLabel;
        this.consumerLabel = consumerLabel;

//        this.gui = new GUI(resourcePool);

        this.activeProducers = new LinkedList<>();
        this.activeConsumers = new LinkedList<>();

=======
    private ResourcePanel resourcePanel;

    private Deque<Producer> producers;
    private Deque<Consumer> consumers;

    private int numProducers;
    private int numConsumers;

    private Timer timer;

    public Manager() {
        this.resourcePool = new ResourcePool(50);
        this.resourcePanel = new ResourcePanel(resourcePool);
        this.producerLabel = new JLabel();
        this.consumerLabel = new JLabel();
        this.numProducers = 6;
        this.numConsumers = 5;
        this.producers = new LinkedList<>();
        this.consumers = new LinkedList<>();

        startProducers();
        startConsumers();
>>>>>>> laboration_3
    }

    public void startSimulation() {
        Timer timer = new Timer(150, this);
        timer.start();

        for (int i = 0; i < startingProducers; i++) {
            Producer producer = new Producer(resourcePool);
<<<<<<< HEAD
            activeProducers.add(producer);
            new Thread(producer).start();
=======
            Thread producerThread = new Thread(producer);
            producerThread.start();
            producers.add(producer);
            getProducers();
            System.out.println("New Producer created: " + producers.size());
>>>>>>> laboration_3
        }
        for (int i = 0; i < startingConsumers; i++) {
            Consumer consumer = new Consumer(resourcePool);
<<<<<<< HEAD
            activeConsumers.add(consumer);
            new Thread(consumer).start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            adjust();
//            gui.repaint();
            updateGUI();
        });
    }

    private void adjust() {

        if (isAdjusting) {
            return;
        }

        isAdjusting = true;

        int availableResources = resourcePool.getResourceAmount();

        if (availableResources > 75) {
            increaseConsumers();
            decreaseProducers();
        } else if (availableResources < 45) {
            increaseProducers();
            decreaseConsumers();
        }

        isAdjusting = false;

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

=======
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
            consumers.add(consumer);
            getConsumers();
            System.out.println("New Consumer created: " + consumers.size());
        }
    }



    private void addProducers() {
        Producer producer = new Producer(resourcePool);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        producers.add(producer);
        getConsumers();
        getProducers();
        System.out.println("Additional Producer created: " + "Producer: " + producers.size());
    }

    private void addConsumers() {
        Consumer consumer = new Consumer(resourcePool);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        consumers.add(consumer);
        getConsumers();
        getProducers();
        System.out.println("Additional Producer created: " + "Producer: " + producers.size());
    }

    private void removeProducers() {
        Thread lastProducer = new Thread(producers.getLast());
        lastProducer.interrupt();
        producers.removeLast();
        System.out.println("Removed Producer");
        System.out.println("Threads active " + Thread.activeCount());
        resourcePanel.updateCounter(getProducers());
    }

    private void removeConsumers() {
        Thread lastConsumer = new Thread(consumers.getLast());
        lastConsumer.interrupt();
        consumers.removeLast();
        System.out.println("Removed Consumer");
        resourcePanel.updateCounter(getConsumers());
    }

    public int getConsumers() {
        return consumers.size();
    }

    public int getProducers() {
        return producers.size();
    }

    public void adjust() {
        int available = resourcePool.getResourceAmount();

        if (available < 40) {
            addProducers();
            removeConsumers();
            System.out.println("More Producers, fewer Consumers");
        }
        else if (available > 180) {
            removeProducers();
            addConsumers();
            System.out.println("More Consumers, fewer Producers");
        }
        // Update the labels on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                updateLabels();
            }
        });
    }

    private void updateLabels() {
        producerLabel.setText("Producers: " + producers.size());
        consumerLabel.setText("Consumers: " + consumers.size());
    }

    public void startAdjustmentTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                adjust();
            }
        }, 0, 150); // Adjust the delay as needed
    }
}


>>>>>>> laboration_3



