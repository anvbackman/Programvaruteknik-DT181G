package com.dt181g.laboration_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public enum Manager {

    INSTANCE;
    private ResourcePool resourcePool;
    private Producer producer;
    private static final int POOL_SIZE = 50;

    private final Queue<ResourcePool> pool;

    private Manager() {
            pool = new LinkedList<>();
            for (int i = 1; i <= POOL_SIZE; i++) {
                pool.offer(new ResourcePool(i));
            }
    }

    public static ResourcePool add() throws InterruptedException {
        synchronized (INSTANCE.pool) {
            while (INSTANCE.pool.isEmpty()) {
                INSTANCE.pool.wait();
            }
            ResourcePool resource = INSTANCE.pool.poll();
            return resource;
        }
    }

    public static void remove(ResourcePool resource) throws InterruptedException {
        synchronized (INSTANCE.pool) {
            INSTANCE.pool.offer(resource);
            INSTANCE.pool.notifyAll();
        }
    }

//    public Manager(ResourcePool resourcePool, Producer producer) {
//        this.resourcePool = resourcePool;
//        this.producer = producer;
//    }




}
