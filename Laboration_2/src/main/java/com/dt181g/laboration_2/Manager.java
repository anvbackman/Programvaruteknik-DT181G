package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Timer;

public class Manager {

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

        startProducers();
        startConsumers();


    }

    private void startProducers() {
        for (int i = 0; i < numProducers; i++) {
            Producer producer = new Producer(resourcePool);
            Thread producerThread = new Thread(producer);
            producerThread.start();
        }
    }

    private void startConsumers() {
        for (int i = 0; i < numConsumers; i++) {
            Consumer consumer = new Consumer(resourcePool);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        }
    }

    public void adjust() {
        int available = resourcePool.getResourceAmount();

        if (available < 40) {
            numProducers++;
            numConsumers--;
            System.out.println("Adjustment: More Producers, Fewer Consumers");
        }
        else if (available > 180) {
            numProducers--;
            numConsumers++;
            System.out.println("Adjustment: Fewer Producers, More Consumers");
        }
        producerLabel.setText("Producers: " + numProducers);
        consumerLabel.setText("Consumers: " + numConsumers);

    }

//    private Deque<Producer> producerDeque;
//    private Deque<Consumer> consumerDeque;




//    private ResourcePool resourcePool;
//    private int maxProducers;
//    private int maxConsumers;
//    private int currentProducers;
//    private int currentConsumers;
//    private List<Observer> observerList;
//    private List<Thread> producerThreads;
//    private List<Thread> consumerThreads;
//
////    private List<Consumer> activeConsumers;
//
//    public Manager(ResourcePool resourcePool, int maxProducers, int maxConsumers) {
//        this.resourcePool = resourcePool;
//        this.maxProducers = maxProducers;
//        this.maxConsumers = maxConsumers;
//        this.observerList = new ArrayList<>();
//        this.currentProducers = maxProducers;
//        this.currentConsumers = maxConsumers;
//        producerThreads = new ArrayList<>();
//        consumerThreads = new ArrayList<>();
////        activeConsumers = new ArrayList<>();
//
//        for (int i = 0; i < 6; i++) {
//            addProducer();
//        }
//        for (int i = 0; i < 5; i++) {
//            addConsumer();
//        }
//    }
//
//    @Override
//    public void add(Observer observer) {
//        this.observerList.add(observer);
//    }
//
//    @Override
//    public void remove(Observer observer) {
//        observerList.remove(observer);
//    }
//
//    @Override
//    public void notifyObserver() {
//        for (Observer observer : observerList) {
//            observer.update();
//        }
//    }
//
//    public List<Observer> getPC() {
//        return this.observerList;
//    }
//
//    public void addProducer() {
//        if (currentProducers < maxProducers) {
//            Producer producer = new Producer(this, resourcePool);
//            Thread producerThread = new Thread(producer);
//            producerThreads.add(producerThread);
//            producerThread.start();
//            currentProducers++;
//            add(producer);
//        }
//    }
//
//    public void addConsumer() {
//        if (currentConsumers < maxConsumers) {
//            Consumer consumer = new Consumer(this, resourcePool);
//            Thread comsumerThread = new Thread(consumer);
//            consumerThreads.add(comsumerThread);
//            comsumerThread.start();
//            currentConsumers++;
//            add(consumer);
//        }
//    }
//
//    public void removeProducer() {
//        Producer producer = new Producer(this, resourcePool);
//        Thread producerThread = new Thread(producer);
//        producerThreads.remove(producerThread);
////        producerThread.interrupt();
//        currentProducers--;
//        remove(producer);
//    }
//
//    public void removeConsumer() {
//        Consumer consumer = new Consumer(this, resourcePool);
//        Thread consumerThread = new Thread(consumer);
//        consumerThreads.remove(consumerThread);
////        consumerThread.interrupt();
//        currentConsumers--;
//        remove(consumer);
//    }
//
//
//    @Override
//    public void run() {
//        int availableResources = resourcePool.getResourceAmount();
//
//        if (availableResources < 50) {
//            if (currentProducers < maxProducers) {
//                addProducer();
//            }
//            if (consumerThreads.size() > 2) {
//                removeConsumer();
//            }
//        } else if (availableResources >= 100) {
//            if (consumerThreads.size() < maxConsumers) {
//                addConsumer();
//            }
//            if (currentProducers > 2) {
//                removeProducer();
//            }
//        }
//        try { Thread.sleep(150);
//        }
//        catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//
//    }

}

//    private Manager() {
//            pool = new LinkedList<>();
//            for (int i = 1; i <= POOL_SIZE; i++) {
//                pool.offer(new ResourcePool(i));
//            }
//    }
//
//    public static ResourcePool add() throws InterruptedException {
//        synchronized (INSTANCE.pool) {
//            while (INSTANCE.pool.isEmpty()) {
//                INSTANCE.pool.wait();
//            }
//            ResourcePool resource = INSTANCE.pool.poll();
//            return resource;
//        }
//    }
//
//    public static void remove(ResourcePool resource) throws InterruptedException {
//        synchronized (INSTANCE.pool) {
//            INSTANCE.pool.offer(resource);
//            INSTANCE.pool.notifyAll();
//        }
//    }

//    public Manager(ResourcePool resourcePool, Producer producer) {
//        this.resourcePool = resourcePool;
//        this.producer = producer;
//    }





