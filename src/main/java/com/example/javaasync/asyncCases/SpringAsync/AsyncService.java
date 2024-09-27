package com.example.javaasync.asyncCases.SpringAsync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncService {

    @Async
    public CompletableFuture<String> asyncMethodWithReturn() {
        log.info("Запуск асинхронного метода с возвратом результата. Поток: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Завершение асинхронного метода с возвратом результата. Поток: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture("Асинхронная задача завершена!");
    }

    @Async("asyncExecutor")
    public void asyncMethodInPool() {
        log.info("Запуск асинхронного метода в пуле asyncExecutor. Поток: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Завершение асинхронного метода в пуле asyncExecutor. Поток: " + Thread.currentThread().getName());
    }
}