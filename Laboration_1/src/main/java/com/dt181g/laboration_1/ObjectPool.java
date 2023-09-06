package com.dt181g.laboration_1;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class ObjectPool<T> {

    private ConcurrentLinkedQueue<T> pool;

    public ObjectPool(int size) {
        pool = new ConcurrentLinkedQueue<T>();
        initialize(size);
    }

    public abstract T create();

    private void initialize(int size) {
        for (int i = 0; i < size; i++) {
            pool.add(create());
        }
    }

    public T getObject() {
        T object = pool.poll();
        if (object == null) {
            object = create();
        }
        return object;
    }

    public void returnObject(T object) {
        if (object == null) {
            return;
        }
        pool.offer(object);
    }

    public int size() {
        System.out.println("Pool size = " + pool.size());
        return pool.size();
    }

    public boolean isAvailable() {
        System.out.println("Is thread = " + pool.isEmpty());

        return !pool.isEmpty();
    }

}
dsjdjaslkdhasdhlkas
