package com.dt181g.laboration_1;

public class Resource {

    private final int id;
    private long startTimer;
    private long endTimer;

    public Resource(int id) {
        System.out.println("Resource with ID: " + id + ", was created");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setStartTimer() {
        startTimer = System.currentTimeMillis();
    }

    public void setEndTimer() {
        endTimer = System.currentTimeMillis();
    }

    public long getTimer() {
        return endTimer - startTimer;
    }
}

