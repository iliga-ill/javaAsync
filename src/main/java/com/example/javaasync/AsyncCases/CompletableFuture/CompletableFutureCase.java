package com.example.javaasync.AsyncCases.CompletableFuture;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class CompletableFutureCase {
    /**
     * аналог stream api но для потоков
     */
    @SneakyThrows
    static public void completableFutureCases(){
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            log.info("Асинхронная задача выполняется в потоке: " + Thread.currentThread().getName());
            return 42;
        });

        future.thenRun(() -> {
            log.info("Задача завершена.");
        });

        Thread.sleep(1000); // Ждем завершения задачи
    }
}
