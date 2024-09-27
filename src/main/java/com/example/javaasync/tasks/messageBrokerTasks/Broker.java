package com.example.javaasync.tasks.messageBrokerTasks;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

import static java.util.Arrays.stream;

@Slf4j
public class Broker {
    Queue<String> messages = new LinkedList<>();
    Integer messageCounter = 0;
    final Broker broker = this;

    @SneakyThrows
    public void startBroker() {
        Runnable messageProducer = () -> {
            try {
                Thread.sleep(2000);
                synchronized (messages) {
                    messages.notify();
                    messageCounter++;
                    String message = "Message " + messageCounter;
                    messages.add(message);
                    log.info("{} produced", message);
                }
            } catch (InterruptedException e) { throw new RuntimeException(e);}
        };

        Runnable messageConsumer = () -> {
            String message;
            try {
                synchronized (messages) {
                    while(messages.isEmpty()) {
                        messages.wait();
                    }
                    message = messages.poll();
                }
                Thread.sleep(1000);
                log.info("{} consumed", message);
            } catch (InterruptedException e) {throw new RuntimeException(e);}
        };

        while(true) {
            Thread.sleep(1000);
            threadStart(messageProducer, messageProducer, messageProducer, messageConsumer, messageConsumer, messageConsumer);
            Thread.sleep(1000);
            threadStart(messageConsumer, messageConsumer, messageConsumer);
        }
    }

    private void threadStart(Runnable... runnables){
        stream(runnables).forEach(runnable -> new Thread(runnable).start());
    }


}
