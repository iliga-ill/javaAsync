package com.example.javaasync.asyncCases.Synchronise;

public class DecrementThread extends Thread {
    private Counter counter;

    public DecrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.decrement();
//            counter.counter--;
            counter.counter.decrementAndGet();
            counter.decrementWithBlock();
        }
    }
}