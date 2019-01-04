package com.useCase.producerConsumerProblem.semaphore;

import java.util.concurrent.Semaphore;


    class Producer implements Runnable {

       Semaphore semaphoreProducer;
       Semaphore semaphoreConsumer;

        public Producer(Semaphore semaphoreProducer, Semaphore semaphoreConsumer) {
            this.semaphoreProducer = semaphoreProducer;
            this.semaphoreConsumer = semaphoreConsumer;
        } 

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                        semaphoreProducer.acquire();
                        System.out.println("Produce :" + i + " by " + Thread.currentThread().getName());
                        semaphoreConsumer.release();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }


    }

