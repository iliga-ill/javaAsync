package com.example.javaasync.AsyncCases;

import com.example.javaasync.ThreadClasses.MyCallable;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class CallableCase {

    /**
     * Callable в отличие от runnable позволяет получить результат задачи
     */
    @SneakyThrows
    public void callable(){
        // Создаем пул из 3 потоков
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Список для хранения Future объектов
        Future<Integer>[] futures = new Future[5];

        // Отправляем 5 задач Callable в пул потоков
        for (int i = 0; i < 5; i++) {
            MyCallable callable = new MyCallable(i + 1);
            futures[i] = executor.submit(callable);  // Получаем Future для каждой задачи
        }

        // Получаем результаты выполнения
        for (Future<Integer> future : futures) {
            // Метод get() блокируется до тех пор, пока результат не станет доступен
            Integer result = future.get();
            log.info("Результат задачи: " + result);
        }

        // Завершаем работу пула потоков
        executor.shutdown();
    }
}
