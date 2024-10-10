package com.dt181g.laboration_2;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.util.Deque;
import java.util.LinkedList;
=======
import java.util.*;
>>>>>>> new_project

/**
 * The Manager class which manages the Producer/Consumer simulation and implements
 * ActionListener in order to handle timer events
 * @author Andreas Backman
 */
public class Manager implements ActionListener {

    private JLabel producerLabel;
    private JLabel consumerLabel;
    private ResourcePool resourcePool;
    private int startingProducers = 6;
    private int startingConsumers = 5;
    private Deque<Producer> activeProducers;
    private Deque<Consumer> activeConsumers;
    private boolean isAdjusting = false;

    /**
     * Constructor that constructs a Manager object taking the resource pool and the producer/consumer labels
     * as parameters
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
            activeProducers.add(producer);
            new Thread(producer).start();
        }
        // Creates and starts the consumers
        for (int i = 0; i < startingConsumers; i++) {
            Consumer consumer = new Consumer(resourcePool);
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

        // Increases consumers and decreases producers once the available resources gets above 150
        if (availableResources > 150) {
            increaseConsumers();
            decreaseProducers();
            // Otherwise increase producers and decrease consumers
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




