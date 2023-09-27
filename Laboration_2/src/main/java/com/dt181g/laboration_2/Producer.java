package com.dt181g.laboration_2;

import java.util.LinkedList;

public class Producer implements Observer, Runnable {
    private Manager manager;
    private ResourcePool resourcePool;

    public Producer(Manager manager, ResourcePool resourcePool) {
        this.manager = manager;
        this.resourcePool = resourcePool;
    }

    @Override
    public void update() {
        System.out.println("Producer received an update");
    }

    @Override
    public void run() {
        int randomProducer = (int) (Math.random() * 10) + 1;
        int producerDelay = (int) (Math.random() * 5000) + 1000;

        try {
            Thread.sleep(producerDelay);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        resourcePool.addResources(randomProducer);
    }

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
