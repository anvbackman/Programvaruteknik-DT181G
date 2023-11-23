package com.dt181g.laboration_2;

import java.util.Random;

/**
 * The Producer class represents the producers in the simulation which implements the Runnable interface
 * so that they can be executed in a separate thread
 *
 * @author Andreas Backman
 */
public class Producer implements Runnable {

    private volatile boolean isRunning = true;
    private ResourcePool resourcePool;

    /**
     * Constructor that constructs a producer with the specified resource pool
     *
     * @param resourcePool the resource pool from which the producer produces resources
     */
    public Producer(ResourcePool resourcePool) {
        this.resourcePool = resourcePool;
    }

    /**
     * Method that is called to stop from producing resources
     */
    public void stop() {
        isRunning = false;
    }

<<<<<<< HEAD
    @Override
=======
    /**
     * Method to execute the producer by continuously produce resources until stopped
     */
>>>>>>> laboration_2
    public void run() {
        Random random = new Random();

        // Keeps running until stopped
        while (isRunning) {
            // Generates a random number between 1 and 10 that amount of resources from the resource pool
            int resources = random.nextInt(10) + 1;
            resourcePool.addResources(resources);
            // Generate a random sleep duration
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
