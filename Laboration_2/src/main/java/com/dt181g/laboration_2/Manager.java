package com.dt181g.laboration_2;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;
=======
import java.util.Timer;
>>>>>>> laboration_3

=======
>>>>>>> laboration_2

/**
 * The Manager class which manages the Producer/Consumer simulation and implements
 * ActionListener in order to handle timer events
 *
 * @author Andreas Backman
 */
public class Manager implements ActionListener {

    private JLabel producerLabel;
    private JLabel consumerLabel;
    private ResourcePool resourcePool;
<<<<<<< HEAD
<<<<<<< HEAD
//    private GUI gui;

=======
>>>>>>> laboration_2
    private int startingProducers = 6;
    private int startingConsumers = 5;
    private Deque<Producer> activeProducers;
    private Deque<Consumer> activeConsumers;
    private boolean isAdjusting = false;

    /**
     * Constructor thet constructs a Manager object taking the resource pool and the producer/consumer labels
     * as parameters
     *
     * @param resourcePool the specified resource pool to be used
     * @param producerLabel the label to display the number of producers
     * @param consumerLabel the label to display the number of consumers
     */
    public Manager(ResourcePool resourcePool, JLabel producerLabel, JLabel consumerLabel) {
        this.resourcePool = resourcePool;
        this.producerLabel = producerLabel;
        this.consumerLabel = consumerLabel;
        this.activeProducers = new LinkedList<>();
        this.activeConsumers = new LinkedList<>();
<<<<<<< HEAD

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
=======
>>>>>>> laboration_2
    }

    /**
     * Method to start the simulation by creating and starting the producers and consumers and
     * also start a timer for adjustments
     */
    public void startSimulation() {
        Timer timer = new Timer(150, this);
        timer.start();

        // Creates and starts the producers
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
        // Creates and starts the consumers
        for (int i = 0; i < startingConsumers; i++) {
            Consumer consumer = new Consumer(resourcePool);
<<<<<<< HEAD
            activeConsumers.add(consumer);
            new Thread(consumer).start();
        }
    }

    /**
     * Method to handle timer events by adjusting the number of producer/consumers
     * @param e the event representing the timer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Executes adjustments and updates the GUI
        SwingUtilities.invokeLater(() -> {
            adjust();
            updateGUI();
        });
    }

    /**
     * Adjusts the number of active producers / consumers based on the resources that are available.
     */
    private void adjust() {
        if (isAdjusting) {
            return;
        }
        isAdjusting = true;

        // Get the available resources
        int availableResources = resourcePool.getResourceAmount();

        // If the amount of available resources are high enough, the consumers are increased and producers are decreased
        if (availableResources > 75) {
            increaseConsumers();
            decreaseProducers();
        // Otherwise if the amount is to low, the amount of producers are increased while the consumers are decreased
        } else if (availableResources < 45) {
            increaseProducers();
            decreaseConsumers();
        }
        isAdjusting = false;
    }

    /**
     * Method to increase producers by creating and starting threads
     */
    private void increaseProducers() {
        Producer producer = new Producer(resourcePool);
        activeProducers.add(producer);
        new Thread(producer).start();
    }

    /**
     * Method to decrease producers by stopping the last active thread
     */
    private void decreaseProducers() {
        // If list is not empty when called, producers are stopped and removed.
        if (!activeProducers.isEmpty()) {
            activeProducers.getLast().stop();
            activeProducers.removeLast();
        }
    }

    /**
     * Method to increase consumers by creating and starting threads
     */
    private void increaseConsumers() {
        Consumer consumer = new Consumer(resourcePool);
        activeConsumers.add(consumer);
        new Thread(consumer).start();
    }

    /**
     * Method to decrease consumers by stopping the last active thread
     */
    private void decreaseConsumers() {
        // If list is not empty when called, consumers are stopped and removed.
        if (!activeConsumers.isEmpty()) {
            activeConsumers.getLast().stop();
            activeConsumers.removeLast();
        }
    }

    /**
     * Method to update the GUI to display the current amount of producers / consumers
     */
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



