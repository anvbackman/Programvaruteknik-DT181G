package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ResourcePool {

    private AtomicInteger resourceAmount;

    private GUI gui;

    public ResourcePool(int startingAmount, GUI gui) {
        this.resourceAmount = new AtomicInteger(startingAmount);
        this.gui = gui;
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
        System.out.println(current);
        SwingUtilities.invokeLater(() -> {
            gui.setColor(color);
        });
    }

    private Color calculateColor(int current) {

        if (current < 50) {
            return Color.RED;
        }
        else if (current < 100) {
            return Color.YELLOW;
        }
        else if (current < 150) {
            return Color.GREEN;
        }
        else {
            return Color.BLUE;
        }
    }


}
