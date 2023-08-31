package com.dt181g.laboration_1;

public class Runner {

    ObjectPool<StockRoom> pool;

    private void setUp(int size) {
        pool = new Manager(size);
    }

    private int getSize() {
        return pool.size();
    }



    public static void main(String[] args) {
        Runner demo = new Runner();
        demo.setUp(5);


    }
}
