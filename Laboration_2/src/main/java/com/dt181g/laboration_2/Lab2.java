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

        final Producer producer = new Producer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread = new Thread(new Runner()); // Creating a new thread for each iteration
        thread.start(); // Starting the thread
        Thread.sleep(50);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
