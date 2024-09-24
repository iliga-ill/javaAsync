package com.example.javaasync.ThreadClasses;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskForThreadPool implements Runnable {
    private final int taskId;

    public TaskForThreadPool(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        log.info("Задача " + taskId + " выполняется в потоке " + Thread.currentThread().getName());
        try {
            // Имитация выполнения задачи
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Задача " + taskId + " прервана.");
        }
        log.info("Задача " + taskId + " завершена.");
    }
}
