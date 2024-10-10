package com.dt181g.laboration_2;

import javax.swing.SwingUtilities;
import java.awt.Color;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The ResourcePool class represents a resource pool in the Producer / Consumer simulation
 * @author Andreas Backman
 */
public class ResourcePool {

    // Atomic integer to ensure atomic operations on the amount of resources
    private AtomicInteger resourceAmount;
    private GUI gui;

    /**
     * Constructor that constructs a Resource pool with the resource starting amount as a parameter
     * @param startingAmount the initial starting amount
     */
    public ResourcePool(int startingAmount) {
        this.resourceAmount = new AtomicInteger(startingAmount);
    }

    /**
     * Method to retrieve the amount of resources available
     * @return the amount of resources available
     */
    public int getResourceAmount() {
        return resourceAmount.get();
    }

    /**
     * Method to add the specified amount of resources to the pool
     * @param amount the amount of resources to be added
     */
    public synchronized void addResources(int amount) {
        resourceAmount.addAndGet(amount);
        visualizeResourcePool();
    }

    /**
     * Method to remove the specified amount of resources from the pool
     * @param amount the amount of resources to be removed
     */
    public synchronized void consumeResources(int amount) {
        resourceAmount.addAndGet(-amount);
        visualizeResourcePool();
    }

    /**
     * Method to visualize the current state of the resource pool by updating the GUI (color of oval)
     */
    private void visualizeResourcePool() {
        int current = resourceAmount.get();
        Color color = calculateColor(current);
        // Updates the GUI and ensure thread safety
        SwingUtilities.invokeLater(() -> {
            gui.setColor(color);
        });
    }

    /**
     * Method to calculate which color the oval should be based on the current size of the resource pool
     * @param current the current size of the resource pool
     * @return the color the oval shall have
     */
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

    /**
     * Method to set the GUI associated with this resource pool
     * @param gui the GUI to be associated with the resource pool
     */
    public void setGUI(GUI gui) {
        this.gui = gui;
    }
}
