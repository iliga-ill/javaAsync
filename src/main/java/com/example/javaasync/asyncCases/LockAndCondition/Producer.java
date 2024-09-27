package com.example.javaasync.asyncCases.LockAndCondition;

public class Producer implements Runnable {
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                resource.produce(i); // Производим данные
                Thread.sleep(1000); // Имитация времени производства
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
