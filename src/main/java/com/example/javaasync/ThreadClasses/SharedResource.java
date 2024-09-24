package com.example.javaasync.ThreadClasses;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class SharedResource {
    private int data;
    private boolean dataAvailable = false;

    // Блокировка для управления доступом
    private final Lock lock = new ReentrantLock();

    // Условие для ожидания данных
    private final Condition condition = lock.newCondition();

    // Метод для записи данных (производитель)
    public void produce(int value) throws InterruptedException {
        lock.lock(); // Захватываем блокировку
        try {
            while (dataAvailable) {
                condition.await(); // Ждем, пока данные не будут потреблены
            }
            this.data = value;
            log.info("Произведено: " + value);
            dataAvailable = true;
            condition.signal(); // Сообщаем потребителю, что данные доступны
        } finally {
            lock.unlock(); // Освобождаем блокировку
        }
    }

    // Метод для чтения данных (потребитель)
    public int consume() throws InterruptedException {
        lock.lock(); // Захватываем блокировку
        try {
            while (!dataAvailable) {
                condition.await(); // Ждем, пока данные не будут произведены
            }
            int consumedData = this.data;
            log.info("Потреблено: " + consumedData);
            dataAvailable = false;
            condition.signal(); // Сообщаем производителю, что данные потреблены
            return consumedData;
        } finally {
            lock.unlock(); // Освобождаем блокировку
        }
    }
}