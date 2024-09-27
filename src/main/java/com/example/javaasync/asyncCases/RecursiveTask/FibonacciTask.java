package com.example.javaasync.asyncCases.RecursiveTask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RecursiveTask;

@Slf4j
public class FibonacciTask extends RecursiveTask<Integer> {
    private final int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        log.info("n = " + n);
        if (n <= 1) return n;
        FibonacciTask task1 = new FibonacciTask(n - 1);
        task1.fork(); // Асинхронное выполнение подзадачи
        FibonacciTask task2 = new FibonacciTask(n - 2);
        return task2.compute() + task1.join(); // Ожидание результата первой подзадачи
    }
}