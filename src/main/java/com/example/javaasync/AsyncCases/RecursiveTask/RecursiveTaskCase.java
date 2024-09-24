package com.example.javaasync.AsyncCases.RecursiveTask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;

@Slf4j
public class RecursiveTaskCase {
    static public void recursiveTask(){
        ForkJoinPool pool = new ForkJoinPool();
        FibonacciTask task = new FibonacciTask(100);
        int result = pool.invoke(task); // Выполнение асинхронной задачи
        log.info("Результат: " + result);
    }
}
