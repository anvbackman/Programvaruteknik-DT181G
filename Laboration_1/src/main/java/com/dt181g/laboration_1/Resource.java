package com.dt181g.laboration_1;

/**
 * Resource class that is used to represent a resources ID and to set a time intervall for how long
 * a thread has been used by the resource.
 *
 * @author Andreas Backman
 */
public class Resource {

    private final int id;
    private long startTimer;
    private long endTimer;

    /**
     * Creating a resource with the specified ID.
     *
     * @param id the resource id
     */
    public Resource(int id) {
        System.out.println("Resource with ID: " + id + ", was created");
        this.id = id;
    }

    /**
     * Gets the ID of the resource
     *
     * @return the ID of the resource
     */
    public int getId() {
        return id;
    }

    /**
     * Method to set starting time
     */
    public void setStartTimer() {
        startTimer = System.currentTimeMillis();
    }

    /**
     * Method to set ending time
     */
    public void setEndTimer() {
        endTimer = System.currentTimeMillis();
    }

    /**
     * Method for calculating how long the thread has held a resource
     * @return the calculated time
     */
    public long getTimer() {
        return endTimer - startTimer;
    }
}

