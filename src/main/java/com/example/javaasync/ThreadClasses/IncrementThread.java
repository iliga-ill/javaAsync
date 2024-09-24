package com.example.javaasync.ThreadClasses;

public class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
//            counter.counter++;
            counter.counter.incrementAndGet();
            counter.incrementWithBlock();
        }
    }
}