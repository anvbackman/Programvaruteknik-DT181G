package com.dt181g.laboration_1;

public class Runner implements Runnable  {
    private final int id;
    public Runner(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Resource resource =  PoolManager.getResource();
                System.out.println("Resource with ID: " + resource.getId() + ", was received by: " + Thread.currentThread().getName());
                Thread.sleep(1000);
                PoolManager.returnResource(resource);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
            }
        }
    }
}
