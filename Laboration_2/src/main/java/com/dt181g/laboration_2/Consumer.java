package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {

    private final ResourcePool resourcePool;
//    private boolean running = true;

    public Consumer(ResourcePool resourcePool) {
        this.resourcePool = resourcePool;
//        removeFromPool();
    }


    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            int resources = random.nextInt(20) + 1;
            resourcePool.consumeResources(resources);

            int sleep = random.nextInt(5000) + 1000;
            try {
                Thread.sleep(sleep);
            }
            catch (InterruptedException e) {
                Thread.interrupted();
            }
        }
    }



//    public void removeFromPool() {
//        try {
//            int random = destroyResource();
//            resourcePool.removeResources(random);
//            System.out.println("Consumer consumed " + random + " resources. Current pool state: " + resourcePool.getResourceAmount());
//            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
//        }
//        catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//
//    public int destroyResource() {
//        int random = ThreadLocalRandom.current().nextInt(1, 20);
//        return random;
//    }

}
