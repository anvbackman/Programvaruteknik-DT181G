package com.dt181g.laboration_1;

import java.util.List;

public class Manager extends ObjectPool<StockRoom> {


    private List<String> names;
    public Manager(int size) {
        super(size);
    }

    @Override
    public StockRoom create() {
        names = List.of("Andreas", "Anders", "Anna", "Abraham", "Augustine");

        StockRoom stockRoom = new StockRoom(names);

        while (isAvailable()) {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Creating instance " + i + " with thread " + i);
            }
        }
        return stockRoom;

    }



}
