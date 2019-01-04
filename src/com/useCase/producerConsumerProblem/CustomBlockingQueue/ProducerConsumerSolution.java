package com.useCase.producerConsumerProblem.CustomBlockingQueue;

public class ProducerConsumerSolution {

    public static void main(String args[]) {
        CustomBlockingQueue<Integer> sharedQueue = new CustomBlockingQueue<>(5);
        Producer p1 = new Producer(sharedQueue);
        Producer p2 = new Producer(sharedQueue);
        Consumer c1 = new Consumer(sharedQueue);
        Consumer c2 = new Consumer(sharedQueue);

        Thread pt1 = new Thread(p1);
        Thread ct1 = new Thread(c1);
        Thread pt2 = new Thread(p2);
        Thread ct2 = new Thread(c2);

        pt1.setName("Producer 1");
        pt2.setName("Producer 2");
        ct1.setName("Consumer 1");
        ct2.setName("Consumer 2");

        ct1.start();
        pt1.start();
    } 

}
