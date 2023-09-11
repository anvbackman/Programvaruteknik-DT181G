package com.dt181g.laboration_1;

/**
 * Lab1 class which creates multiple threads using the Sender class. It then starts
 * them with a delay in between each iteration.
 * @author Andreas Backman
 */
public class Lab1 {

    /**
     * Main method of the Runner class
     * @param args the command-line argument
     * @throws InterruptedException if a thread is interrupted during sleep
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runner(i)); // Creating a new thread for each iteration
            thread.start(); // Starting the thread
            Thread.sleep(50); // Short sleep between each thread start
        }
    }
}