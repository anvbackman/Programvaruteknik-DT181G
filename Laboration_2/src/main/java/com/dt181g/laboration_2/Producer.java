package com.dt181g.laboration_2;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

    private ResourcePool resourcePool;
//    private boolean running = false;

    public Producer(ResourcePool resourcePool) {
        this.resourcePool = resourcePool;

    }

//    public void addToPool() {
//        try {
//            int random = addResource();
//            resourcePool.addResources(random);
//            System.out.println("Producer added " + random + " resources. Current pool state: " + resourcePool.getResourceAmount());
//            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
//        }
//        catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//    }
//
//
//
//    public int addResource() {
//        int random = ThreadLocalRandom.current().nextInt(1, 10);
//        return random;
//    }

    public void run() {
        Random random = new Random();

        while (true) {
            int resources = random.nextInt(10) + 1;
            resourcePool.addResources(resources);

            int sleep = random.nextInt(5000) + 1000;
            try {
                Thread.sleep(sleep);
            }
            catch (InterruptedException e) {
                Thread.interrupted();
            }
        }
    }

//    private Manager manager;
//    private ResourcePool resourcePool;
//
//    public Producer(Manager manager, ResourcePool resourcePool) {
//        this.manager = manager;
//        this.resourcePool = resourcePool;
//    }
//
//    @Override
//    public void update() {
//        System.out.println("Producer received an update");
//    }
//
//    @Override
//    public void run() {
//        int randomProducer = (int) (Math.random() * 10) + 1;
//        int producerDelay = (int) (Math.random() * 5000) + 1000;
//
//        try {
//            Thread.sleep(producerDelay);
//        }
//        catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            return;
//        }
//        resourcePool.addResources(randomProducer);
//    }

//    private LinkedList<Integer> list = new LinkedList<>();
//    private int capacity = 6;
//
//    public void produce() throws InterruptedException {
//        int value = 0;
//        while (true) {
//            synchronized (this) {
//                while (list.size() == capacity) {
//                    wait();
//                }
//                System.out.println("Producer produced " + value);
//                list.add(value++);
//                notify();
//                Thread.sleep(1000);
//            }
//        }
//    }
//    public void consume() throws InterruptedException {
//        while (true) {
//            synchronized (this) {
//                while (list.size() == 0) {
//                    wait();
//
//                    int val = list.removeFirst();
//                    System.out.println("Consumer consumed " + val);
//                    notify();
//                    Thread.sleep(1000);
//                }
//            }
//        }
//    }



//    private ResourcePool resourcePool = new ResourcePool();
//    public Producer(ResourcePool resourcePool) {
//        this.resourcePool = resourcePool;
//    }
//
//    public void run() {
//        int increment = 0;
//        while (true) {
//            resourcePool.add(increment++);
//            try {
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e) {
//                Thread.interrupted();
//            }
//
//        }
//
//    }



}
