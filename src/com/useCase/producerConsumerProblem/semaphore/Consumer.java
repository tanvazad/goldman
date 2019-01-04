package com.useCase.producerConsumerProblem.semaphore;
// Java program to implement solution of producer
// consumer problem.


import java.util.concurrent.Semaphore;


class Consumer implements Runnable {


    Semaphore semaphoreProducer;
    Semaphore semaphoreConsumer;

    public Consumer(Semaphore semaphoreConsumer, Semaphore semaphoreProducer) {
        this.semaphoreConsumer = semaphoreConsumer;
        this.semaphoreProducer = semaphoreProducer;
    } 

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                semaphoreConsumer.acquire();
                System.out.println("Consume :" + i + " by " + Thread.currentThread().getName());
                semaphoreProducer.release();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}




