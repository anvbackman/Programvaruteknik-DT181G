package com.dt181g.laboration_2;

public class Runner implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                ResourcePool resource = Manager.add();
                System.out.println("Resource was received by: " + Thread.currentThread().getName());
                Thread.sleep(1000);
                Manager.remove(resource);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
