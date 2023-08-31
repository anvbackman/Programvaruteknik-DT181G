package com.dt181g.laboration_1;

public class Manager extends ObjectPool<StockRoom> {


    private int stockNumber = 1234;
    public Manager(int size) {
        super(size);
    }

    @Override
    public StockRoom create() {
        StockRoom stockRoom = new StockRoom(stockNumber);
        System.out.println("Creating instance with instance Id " + stockRoom.getInstanceId());
        return stockRoom;
    }




}
