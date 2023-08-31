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
        if (size() != 5) {
            System.out.println("Thread in use!");
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
        return pool.size();
    }

}
