package com.dt181g.laboration_1;

public class Worker implements Runnable {

    private ObjectPool<StockRoom> pool;
    public Worker(ObjectPool<StockRoom> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        StockRoom stockRoom = pool.getObject();
        printInstanceId(stockRoom);

        try {
            Thread.sleep(1000);
    }

    private void printInstanceId(StockRoom stockRoom) {
        System.out.println("Instance Id: " + stockRoom.getInstanceId());
    }

    private void printPoolSize(Runner demo) {
        System.out.println("Pool size: " + demo.getSize());
    }

}
