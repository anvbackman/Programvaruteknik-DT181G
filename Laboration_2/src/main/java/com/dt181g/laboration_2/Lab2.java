package com.dt181g.laboration_2;

import java.util.Timer;
import java.util.TimerTask;

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



        // Ensure that the program continues running
        while (true) {
            ResourcePool resourcePool = new ResourcePool(50);
            Manager manager = new Manager(resourcePool);

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    manager.adjust();
                }
            }, 0, 150); // Adjust the delay as needed
        }
    }

}
