package com.dt181g.laboration_1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PoolManager class that mmanages a pool of resources
 * @author Andreas Backman
 */
public class PoolManager {

    private static final PoolManager poolManager = new PoolManager();

    private static final int POOL_SIZE = 5;

    private final Queue<Resource> pool;

    private PoolManager() {
        pool = new LinkedList<>();
        for (int i = 1; i <= POOL_SIZE; i++) {
            pool.offer(new Resource(i));
        }
    }

    public static Resource getResource() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is ready to be used");
        synchronized (poolManager) {
            while(poolManager.pool.isEmpty()) {
                poolManager.wait();
            }
            Resource resource = poolManager.pool.poll();
            resource.setStartTimer();
            return resource;
        }
    }

    public static void returnResource(Resource resource) {
        resource.setEndTimer();
        System.out.println("Resource with ID: " + resource.getId() + ", was returned from: " + Thread.currentThread().getName()
                + ", after being held for " + resource.getTimer() + " milliseconds");
        synchronized (poolManager.pool) {
            poolManager.pool.offer(resource);
            poolManager.pool.notifyAll();
        }
    }
}

