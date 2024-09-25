package com.example.javaasync.AsyncCases.SpringAsync;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SpringAsyncCase {

    @Autowired
    private AsyncService asyncService; // Внедряем через Spring-контекст

    /**
     * асинхронный метод средствами спринга
     */
    @SneakyThrows
    public void springAsync(){
        var response = asyncService.asyncMethodWithReturn();

        log.info(response.get());
    }

    /**
     * асинхронный метод в пуле asyncExecutor средствами спринга
     */
    @SneakyThrows
    public void springAsyncInPool(){
        asyncService.asyncMethodInPool();
    }

}
