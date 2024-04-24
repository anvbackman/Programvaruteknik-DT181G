package com.dt181g.laboration_2;

import java.util.Random;

/**
 * The Consumer class represents the consumers in the simulation which implements the Runnable interface
 * so that they can be executed in a separate thread
 * @author Andreas Backman
 */
public class Consumer implements Runnable {
    private volatile boolean isRunning = true;
    private ResourcePool resourcePool;

    /**
     * Constructor that constructs a consumer with the specified resource pool
     * @param resourcePool the resource pool from which the consumer consumes resources
     */
    public Consumer(ResourcePool resourcePool) {
        this.resourcePool = resourcePool;
    }

    /**
     * Method that is called to stop from consuming resources
     */
    public void stop() {
        isRunning = false;
    }

    /**
     * Method to execute the consumer by continuously consume resources until stopped
     */
    @Override
    public void run() {
        Random random = new Random();

        // Keeps running until stopped
        while (isRunning) {
            int resources = random.nextInt(20) + 1; // Generate a random amount of resources to consume
            resourcePool.consumeResources(resources); // Consume the resources
            // Generate a random sleep duration
            int sleep = random.nextInt(5000) + 1000;
            try {
                Thread.sleep(sleep);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
