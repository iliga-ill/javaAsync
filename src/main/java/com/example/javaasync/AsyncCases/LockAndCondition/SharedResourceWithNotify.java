package com.example.javaasync.AsyncCases.LockAndCondition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SharedResourceWithNotify extends SharedResource {
    private int data;
    private boolean dataAvailable = false;

    @Override
    // Метод для записи данных (производитель)
    public synchronized void produce(int value) throws InterruptedException {
        while (dataAvailable) {
            wait(); // Ждем, пока данные не будут потреблены
        }
        this.data = value;
        log.info("Произведено: " + value);
        dataAvailable = true;
        notify(); // Пробуждаем потребителя
    }

    @Override
    // Метод для чтения данных (потребитель)
    public synchronized int consume() throws InterruptedException {
        while (!dataAvailable) {
            wait(); // Ждем, пока данные не будут произведены
        }
        int consumedData = this.data;
        log.info("Потреблено: " + consumedData);
        dataAvailable = false;
        notify(); // Пробуждаем производителя
        return consumedData;
    }
}
