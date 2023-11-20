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

}
