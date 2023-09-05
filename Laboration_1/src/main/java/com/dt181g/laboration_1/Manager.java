package com.dt181g.laboration_1;

public class Manager extends ObjectPool<StockRoom> {


    private int stockNumber = 1234;
    public Manager(int size) {
        super(size);
    }

    @Override
    public StockRoom create() {
        StockRoom stockRoom = new StockRoom(stockNumber);
        for (int i = 1; i <= 5; i++) {
            if (isAvailable()) {
                System.out.println("Creating instance " + i + "with thread " + i);
            }

        }
        return stockRoom;
    }



}
