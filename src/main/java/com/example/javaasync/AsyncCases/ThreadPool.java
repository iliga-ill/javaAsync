package com.example.javaasync.AsyncCases;

import com.example.javaasync.ThreadClasses.TaskForThreadPool;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPool {

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
}
