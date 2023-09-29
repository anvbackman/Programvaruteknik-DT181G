package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ResourcePool {

    private int resourceAmount;

    public ResourcePool(int resourceAmount) {
        this.resourceAmount = resourceAmount;
    }

    public synchronized void addResources(int amount) {
        resourceAmount += amount;
        System.out.println("Added " + amount + " resources. Total resources " + resourceAmount);
        notifyAll();
    }

    public synchronized void removeResources(int amount) {
        while (resourceAmount < amount) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        resourceAmount -= amount;
        System.out.println("Consumed " + amount + " resources. Total resources " + resourceAmount);
    }

    public synchronized int getResourceAmount() {
        return resourceAmount;
    }



}
