package com.example.javaasync.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    // Pointcut для методов, начинающихся на run, thread или runnable
    @Before("(execution(* run(..)) || execution(* thread*(..)) || execution(* runnable*(..)) || execution(* start(..))) && within(*..*My*)")
    public void logBeforeMethod(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName(); // Получаем информацию о классе и методе
        String methodName = joinPoint.getSignature().getName();
        Thread currentThread = Thread.currentThread(); // Получаем текущий поток

        // Логируем класс, метод и поток
        log.info("Класс: {}, Метод: {}, Поток: {}", className, methodName, currentThread.getName());
    }
}