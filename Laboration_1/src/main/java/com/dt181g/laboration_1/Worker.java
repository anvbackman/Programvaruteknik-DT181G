package com.dt181g.laboration_1;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

    private ObjectPool<StockRoom> pool;

    public Worker(ObjectPool<StockRoom> pool) {
        this.pool = pool;

    }

    @Override
    public void run() {
        StockRoom stockRoom = pool.getObject();
//        printInstanceId(stockRoom);

//        try {
//            while (!pool.isAvailable()) {
//                System.out.println("Waiting for resource");
//                Thread.sleep(1000);
//            }
//        }
//        catch (InterruptedException e) {
////            e.printStackTrace();
//            Thread.currentThread().interrupt();
//        }

        while (pool.isAvailable()) {
            try {
                Thread.sleep(1000); // Simulate work for 1 second
            } catch (InterruptedException e) {
                System.out.println("Caught");
                Thread.currentThread().interrupt();

            }

            pool.returnObject(stockRoom);
        }


    }

    private void printInstanceId(StockRoom stockRoom) {
        System.out.println("Instance Id: " + stockRoom.getInstanceId());
    }

    public void printPoolSize(Runner demo) {
        System.out.println("Pool size: " + demo.getSize());
    }



}
