package com.example.javaasync;

import com.example.javaasync.AsyncCases.RecursiveTask.RecursiveTaskCase;
import com.example.javaasync.utils.Logs;
import com.sun.tools.javac.Main;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
@Slf4j
public class JavaAsyncApplication {

	@SneakyThrows
	public static void main(String[] args) {
		SpringApplication.run(JavaAsyncApplication.class, args);
		Logs.printCurThread(Thread.currentThread(), Main.class);



	}



}
