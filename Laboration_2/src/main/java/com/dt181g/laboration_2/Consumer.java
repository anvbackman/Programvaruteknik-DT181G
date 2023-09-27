package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Consumer implements Observer, Runnable {

    private Manager manager;
    private ResourcePool resourcePool;

    public Consumer(Manager manager, ResourcePool resourcePool) {
        this.manager = manager;
        this.resourcePool = resourcePool;
    }

    @Override
    public void update() {
        System.out.println("Consumer received an update");
    }

    @Override
    public void run() {
        int randomConsumer = (int) (Math.random() * 20) + 1;
        int consumerDelay = (int) (Math.random() * 5000) + 1000;

        try {
            Thread.sleep(consumerDelay);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        resourcePool.removeResources(randomConsumer);
    }

}
