package com.example.javaasync.AsyncCases.LockAndCondition;

public class lockNConditionCase {
    /**
     * пример с использованием notify
     */
    public void conditionWithNotify(){
        SharedResourceWithNotify sharedResource = new SharedResourceWithNotify();

        Thread producerThread = new Thread(new Producer(sharedResource));
        Thread consumerThread = new Thread(new Consumer(sharedResource));

        producerThread.start();
        consumerThread.start();
    }

    /**
     * В примере 5 раз производятся и потребляются данные, при этом потребитель ждет, пока данные произведутся, и наоборот
     */
    public void condition(){
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(new Producer(sharedResource));
        Thread consumerThread = new Thread(new Consumer(sharedResource));

        producerThread.start();
        consumerThread.start();
    }
}
