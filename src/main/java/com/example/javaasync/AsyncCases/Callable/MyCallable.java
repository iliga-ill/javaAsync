package com.example.javaasync.AsyncCases.Callable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public
class MyCallable implements Callable<Integer> {
    private final int taskId;

    public MyCallable(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public Integer call() throws Exception {
        log.info("Задача " + taskId + " выполняется в потоке " + Thread.currentThread().getName());
        // Имитация долгой задачи
        Thread.sleep(2000);
        return taskId * 10;  // Возвращаем результат
    }
}