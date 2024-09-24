package com.example.javaasync.AsyncCases.Threads;

import com.example.javaasync.utils.Logs;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyRunnable implements java.lang.Runnable {
    @SneakyThrows
    public void run() {
        Logs.printCurThread(Thread.currentThread(), this.getClass());
        log.info("{} work started", this.getClass().getSimpleName());
        Thread.sleep(2000);
        log.info("{} work ended", this.getClass().getSimpleName());

    }
}