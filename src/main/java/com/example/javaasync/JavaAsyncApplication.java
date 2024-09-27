package com.example.javaasync;

import com.example.javaasync.asyncCases.SpringAsync.AsyncService;
import com.example.javaasync.tasks.messageBrokerTasks.Broker;
import com.example.javaasync.utils.Logs;
import com.sun.tools.javac.Main;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
@EnableAsync
@Slf4j
public class JavaAsyncApplication {

	@SneakyThrows
	public static void main(String[] args) {
		var context = SpringApplication.run(JavaAsyncApplication.class, args);
		Logs.printCurThread(Thread.currentThread(), Main.class);

		new Broker().startBroker();

	}
}
