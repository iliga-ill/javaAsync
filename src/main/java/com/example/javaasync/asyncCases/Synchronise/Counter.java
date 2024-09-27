package com.example.javaasync.asyncCases.Synchronise;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    public AtomicInteger counter = new AtomicInteger(0);
    public int blockedCounter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    // Синхронизированный метод для безопасного инкремента
    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized void incrementWithBlock() {
        lock.lock();  // Блокировка
        blockedCounter++;
        lock.unlock();  // Освобождение блокировки
    }

    public synchronized void decrementWithBlock() {
        lock.lock();  // Блокировка
        blockedCounter--;
        lock.unlock();  // Освобождение блокировки
    }

    public int getCount() {
        return count;
    }
}
