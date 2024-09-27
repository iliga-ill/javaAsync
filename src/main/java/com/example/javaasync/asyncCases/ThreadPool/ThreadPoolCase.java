package com.example.javaasync.asyncCases.ThreadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPoolCase {

    /**
     * Позволяет создавать пул потоков, обрабатывающих задачи, и при этом переиспользуемых при необходимости
     */
    public void pools(){
        // Создаем пул из 3 потоков
//		ExecutorService executor = Executors.newFixedThreadPool(3); //набор потоков, фиксированное кол-во
        ExecutorService executor = Executors.newCachedThreadPool(); //набор потоков, не фиксированное кол-во
//        ExecutorService executor = Executors.newSingleThreadExecutor(); //один поток, последовательное выполнение кода
//        ExecutorService executor = Executors.newScheduledThreadPool(3); //набор scheduled потоков, позволяет настраивать интервалы/время выполнения задач

        // Создаем и отправляем 5 задач в пул потоков
        for (int i = 1; i <= 5; i++) {
            TaskForThreadPool task = new TaskForThreadPool(i);
            executor.submit(task);
        }

        // Завершаем прием новых задач
        executor.shutdown();

//		try {
//			// Ожидаем завершения всех задач
//			if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
//				executor.shutdownNow();
//			}
//		} catch (InterruptedException e) {
//			executor.shutdownNow();
//		}

        log.info("Все задачи отправлены в пул потоков.");
    }

    /**
     * Позволяет создавать пул потоков, обрабатывающих задачи, и при этом переиспользуемых при необходимости
     */
    public static void poolWithLambda() {
		ExecutorService executor = Executors.newFixedThreadPool(3); //набор потоков, фиксированное кол-во

        // Создаем и отправляем 5 задач в пул потоков
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            executor.submit(() -> {
                log.info("Задача " + finalI + " выполняется в потоке " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // Имитация выполнения задачи
                } catch (InterruptedException ignored) {}
                log.info("Задача " + finalI + " завершена.");
            });
        }

        // Завершаем прием новых задач
        executor.shutdown();

//		try {
//			// Ожидаем завершения всех задач
//			if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
//				executor.shutdownNow();
//			}
//		} catch (InterruptedException e) {
//			executor.shutdownNow();
//		}

        log.info("Все задачи отправлены в пул потоков.");
    }
}
