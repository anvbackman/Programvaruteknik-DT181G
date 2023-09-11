package com.dt181g.laboration_1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PoolManager class implemented as an enum Singleton that manages a pool of resources
 * which provides methods to acquire and return resources in a thread-safe manner.
 * @author Andreas Backman
 */
public enum PoolManager {

    INSTANCE;

    private static final int POOL_SIZE = 5;

    private final Queue<Resource> pool;

    /**
     * Private constructor that initializes the resource pool
     * and then creates resources that gets added to the pool.
     */
    private PoolManager() {
        pool = new LinkedList<>();
        for (int i = 1; i <= POOL_SIZE; i++) {
            pool.offer(new Resource(i));
        }
    }

    /**
     * Method used to get resources from the pool.
     *
     * @return a resource from the pool
     * @throws InterruptedException if the thread is interrupted while its waiting for a resource
     */
    public static Resource getResource() throws InterruptedException {
        // Prints a message to tell when a thread is ready to be used
        System.out.println(Thread.currentThread().getName() + " is ready to be used");
        synchronized (INSTANCE.pool) {
            // Loop to wait until a resource is available
            while(INSTANCE.pool.isEmpty()) {
                INSTANCE.pool.wait();
            }
            Resource resource = INSTANCE.pool.poll(); // Get a resource from the pool
            resource.setStartTimer(); // Starts a timer for when the resource is received
            return resource;
        }
    }

    /**
     * Method used to return a resource back to the pool
     * @param resource the resource to be returned
     */
    public static void returnResource(Resource resource) {
        resource.setEndTimer(); // Sets the timer for when a resource is returned
        // Prints a message for the return
        System.out.println("Resource with ID: " + resource.getId() + ", was returned from: " + Thread.currentThread().getName()
                + ", after being held for " + resource.getTimer() + " milliseconds");
        synchronized (INSTANCE.pool) {
            INSTANCE.pool.offer(resource); // Adds resource back to the pool
            INSTANCE.pool.notifyAll(); // Notifies all waiting threads that a resource is available
        }
    }
}

