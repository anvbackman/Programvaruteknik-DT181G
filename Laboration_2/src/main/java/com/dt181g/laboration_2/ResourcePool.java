package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ResourcePool {

    private AtomicInteger resourceAmount;

    private GUI gui;

    public ResourcePool(int startingAmount) {
        this.resourceAmount = new AtomicInteger(startingAmount);
    }

    public int getResourceAmount() {
        return resourceAmount.get();
    }

    public synchronized void addResources(int amount) {
        resourceAmount.addAndGet(amount);
        visualizeResourcePool();
    }

    public synchronized void consumeResources(int amount) {
        resourceAmount.addAndGet(-amount);
        visualizeResourcePool();

    }

    private void visualizeResourcePool() {
        int current = resourceAmount.get();
        Color color = calculateColor(current);

        SwingUtilities.invokeLater(() -> {
            gui.setColor(color);
        });
    }

    private Color calculateColor(int current) {

        if (getResourceAmount() < 50) {
            return Color.RED;
        }
        else if (getResourceAmount() < 100) {
            return Color.YELLOW;
        }
        else if (getResourceAmount() < 150) {
            return Color.GREEN;
        }
        else {
            return Color.BLUE;
        }
    }

//    public synchronized void addResources(int amount) {
//        resourceAmount += amount;
//        System.out.println("Added " + amount + " resources. Total resources " + resourceAmount);
//        notifyAll();
//    }
//
//    public synchronized void removeResources(int amount) {
//        while (resourceAmount < amount) {
//            try {
//                wait();
//            }
//            catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                return;
//            }
//        }
//        resourceAmount -= amount;
//        System.out.println("Consumed " + amount + " resources. Total resources " + resourceAmount);
//    }
//
//    public synchronized int getResourceAmount() {
//        return resourceAmount;
//    }



}
