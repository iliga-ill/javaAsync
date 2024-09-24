package com.example.javaasync.AsyncCases.Threads;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ThreadJoinCase {
    /**
     * потоки сначала запускаются через start, и потом join к основному потоку.
     * join останавливает основной поток пока второстепенный не отработает полностью
     * Не важно какой из потоков работает дольше, из-за последовательного join основной поток будет ждать только
     * максимальное время обработки потока, т.е. основной поток отработает за максимально короткое время, равное максимальному
     * времени работы одного из потоков, дождется его, после чего завершится
     */
    @SneakyThrows
    public void joinCase(){
        MyThread1 thread = new MyThread1();
		thread.start(); // Запускает новый поток, который выполняет метод run()
		log.info("Поток MyThread1 запущен");

		Thread thread2 = new Thread(new MyRunnable());
		thread2.start(); // Поток запущен
		log.info("Поток MyRunnable запущен");

		log.info("Поток MyThread1 join");
		thread.join();

		log.info("Поток MyRunnable join");
		thread2.join();

        log.info("Основной поток завершен.");
    }

    /**
     * Не отработает асинхронно потому что сразу после создания потока мы его join'им, из-за чего следующий поток не
     * стартует пока не отработает прошлый
     */
    public void joinForEachNotAsyncCase(){
        var threads = List.of(new MyThread1(), new Thread(new MyRunnable()));

        threads.forEach(thread -> {
            thread.start();
            log.info("join");
            try {
                thread.join();
            } catch (InterruptedException ignored) {}
        });

        log.info("Основной поток завершен.");
    }

    /**
     * Отрабатывает асинхронно, потому что все потоки сначала запускаются, и уже после join'ятся к основному потоку
     */
    public void joinForEachAsyncCase(){
        var threads = List.of(new MyThread1(), new Thread(new MyRunnable()));

        threads.forEach(thread -> {
            thread.start();
        });

        threads.forEach(thread -> {
            try {
                log.info("join");
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        log.info("Основной поток завершен.");
    }
}
