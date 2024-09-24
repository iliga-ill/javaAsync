package com.example.javaasync.ThreadClasses;

public class Consumer implements Runnable {
    private final SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                resource.consume(); // Потребляем данные
                Thread.sleep(2000); // Имитация времени потребления
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}