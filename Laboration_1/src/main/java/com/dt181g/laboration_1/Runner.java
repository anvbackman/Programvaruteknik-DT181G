package com.dt181g.laboration_1;

public class Runner {

    ObjectPool<StockRoom> pool;

    private void setUp(int size) {
        pool = new Manager(size);
    }

    public int getSize() {
        return pool.size();
    }



    public static void main(String[] args) {
        Runner demo = new Runner();
        demo.setUp(5);

        Worker worker = new Worker(demo.pool);

        Thread[] threads = new Thread[5];
//        System.out.println(demo.getSize());
//
//        StockRoom first = demo.pool.getObject();
//        System.out.println(demo.getSize());
//        demo.pool.returnObject(first);
//        System.out.println(demo.getSize());


//        while (pool.isAvailable())
//        if (demo.getSize() != 5) {
//            try {
//                demo.wait();
//            }
//            catch (InterruptedException e) {
//
//
//        }
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(worker);
        }

        for (Thread thread : threads) {
            thread.start();
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }



    }
}
