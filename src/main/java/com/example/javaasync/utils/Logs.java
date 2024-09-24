package com.example.javaasync.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Logs {
    public static <T> void printCurThread(Thread thread, Class<T> user){
        log.info("Класс {}, поток: {}", user.getSimpleName(), thread.getName());
    }

    Double time = 0.0;
    @Scheduled(fixedDelay = 500)
    private void timer(){
        time= time + 0.5;
        log.info("second {}", time);
    }
}
