package com.example.javaasync.AsyncCases;

import com.example.javaasync.ThreadClasses.Consumer;
import com.example.javaasync.ThreadClasses.Producer;
import com.example.javaasync.ThreadClasses.SharedResource;

public class lockNConditionCase {
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
