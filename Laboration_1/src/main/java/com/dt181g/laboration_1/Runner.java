package com.dt181g.laboration_1;

/**
 * Runner class that implements Runnable interface that acquires resources from the pool
 * uses them and then returns the resource back into the pool.
 *
 *
 * @author Andreas Backman
 */
public class Runner implements Runnable  {
    private final int id;

    /**
     * Creates a new Runner with the provided id
     *
     * @param id the id for the runner
     */
    public Runner(int id) {
        this.id = id;
    }

    /**
     * Method to execute the runner thread by running through a loop that acquires resources, use them and then
     * return the resource back into the pool while also handeling interruptions
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Resource resource =  PoolManager.getResource(); // Acquire a resource from the pool
                // Prints a message using the resource id and thread name
                System.out.println("Resource with ID: " + resource.getId() + ", was received by: " + Thread.currentThread().getName());
                Thread.sleep(1000); // Making the thread sleep
                PoolManager.returnResource(resource); // Returns the resource to the pool
            }
            catch (InterruptedException e) { // Throws InterruptedException if current thread is interrupted
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
            }
        }
    }

<<<<<<< HEAD
    /**
     * Method to start the threads
     *
     * @throws InterruptedException if an interruption occurs while threads are being started
     */
=======
>>>>>>> new_project
    public static void startThreads() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runner(i)); // Creating a new thread for each iteration
            thread.start(); // Starting the thread
            Thread.sleep(50); // Short sleep between each thread start
        }
    }
}
