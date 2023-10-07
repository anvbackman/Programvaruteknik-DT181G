package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

public class Manager {

    private JLabel producerLabel;
    private JLabel consumerLabel;
    private ResourcePool resourcePool;
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
    }

    private void startProducers() {
        for (int i = 0; i < numProducers; i++) {
            Producer producer = new Producer(resourcePool);
            Thread producerThread = new Thread(producer);
            producerThread.start();
            producers.add(producer);
            getProducers();
            System.out.println("New Producer created: " + producers.size());
        }
    }

    private void startConsumers() {
        for (int i = 0; i < numConsumers; i++) {
            Consumer consumer = new Consumer(resourcePool);
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





