package com.dt181g.laboration_2;

/**
 * The main starting point for laboration 2.
 * @author Erik Ström
 */
public final class Lab2 {
    private Lab2() { // Utility classes should not have a public or default constructor
        throw new IllegalStateException("Utility class");
    }

    /**
     * Simple output of the assignment's name. Be sure to replace
     * this when working with the assignment!
     * @param args command arguments.
     */
    public static void main(final String... args) throws InterruptedException {

        ResourcePool resourcePool = new ResourcePool(50);
        Manager manager = new Manager(resourcePool, 6, 5);
        
        Runnable managerRunnable = new Runnable() {
            @Override
            public void run() {
                manager.run();
            }
        };

        Thread managerThread = new Thread(managerRunnable);
        managerThread.start();



    }

}
