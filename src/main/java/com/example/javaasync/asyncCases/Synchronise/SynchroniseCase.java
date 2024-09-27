package com.example.javaasync.asyncCases.Synchronise;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchroniseCase {

    /**
     * Если в классе Counter у методов increment/decrement не будет тега synchronized, то итоговое число, полученное Counter не будет равно -1000
     */
    public void SynchroniseCase1(){
        Counter counter = new Counter();

        // Создаем несколько потоков
        Thread thread1 = new IncrementThread(counter);
        Thread thread2 = new IncrementThread(counter);
        Thread thread3 = new IncrementThread(counter);
        Thread thread4 = new DecrementThread(counter);
        Thread thread5 = new DecrementThread(counter);
        Thread thread6 = new DecrementThread(counter);
        Thread thread7 = new DecrementThread(counter);

        // Запускаем потоки
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

        try {
            // Ждем завершения всех потоков
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Выводим итоговый результат
        log.info("Итоговое значение счетчика: {}", counter.getCount());
    }

    /**
     * То же самое касается переменных, если использовать просто int, то значение не будет -1000, но с AtomicInt операции синхронизируются
     */
    public void syncCase2() {
        Counter counter = new Counter();

        // Создаем несколько потоков
        Thread thread1 = new IncrementThread(counter);
        Thread thread2 = new IncrementThread(counter);
        Thread thread3 = new IncrementThread(counter);
        Thread thread4 = new DecrementThread(counter);
        Thread thread5 = new DecrementThread(counter);
        Thread thread6 = new DecrementThread(counter);
        Thread thread7 = new DecrementThread(counter);

        // Запускаем потоки
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

        try {
            // Ждем завершения всех потоков
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Выводим итоговый результат
        log.info("Итоговое значение счетчика: {}", counter.counter.intValue());
    }

    /**
     * инкрементация с использованием залочивания ресурсов с помощью ReentrantLock в Counter
     */
    public void syncWithLockCase(){
        Counter counter = new Counter();

        // Создаем несколько потоков
        Thread thread1 = new IncrementThread(counter);
        Thread thread2 = new IncrementThread(counter);
        Thread thread3 = new IncrementThread(counter);
        Thread thread4 = new DecrementThread(counter);
        Thread thread5 = new DecrementThread(counter);
        Thread thread6 = new DecrementThread(counter);
        Thread thread7 = new DecrementThread(counter);

        // Запускаем потоки
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

        try {
            // Ждем завершения всех потоков
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Выводим итоговый результат
        log.info("Итоговое значение счетчика: {}", counter.blockedCounter);
    }

}
