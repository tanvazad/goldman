package com.useCase.producerConsumerProblem;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer
{
    public static void main(String args[]) {
        Vector sharedQueue = new Vector();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
        Thread prodThread1 = new Thread(new Producer(sharedQueue, size), "Producer1");
        Thread consThread1 = new Thread(new Consumer(sharedQueue, size), "Consumer1");
        Thread prodThread2 = new Thread(new Producer(sharedQueue, size), "Producer2");
        Thread consThread2 = new Thread(new Consumer(sharedQueue, size), "Consumer2");
        Thread prodThread3 = new Thread(new Producer(sharedQueue, size), "Producer3");
        Thread consThread3 = new Thread(new Consumer(sharedQueue, size), "Consumer3");
        Thread prodThread4 = new Thread(new Producer(sharedQueue, size), "Producer4");
        Thread consThread4 = new Thread(new Consumer(sharedQueue, size), "Consumer4");
        Thread prodThread5 = new Thread(new Producer(sharedQueue, size), "Producer5");
        Thread consThread5 = new Thread(new Consumer(sharedQueue, size), "Consumer5");
        Thread prodThread6 = new Thread(new Producer(sharedQueue, size), "Producer6");
        Thread consThread6 = new Thread(new Consumer(sharedQueue, size), "Consumer6");
        prodThread.start();
        prodThread1.start();
        prodThread2.start();
        prodThread3.start();
        prodThread4.start();
        prodThread5.start();
        prodThread6.start();
        consThread.start();
        consThread1.start();
        consThread2.start();
        consThread3.start();
        consThread4.start();
        consThread5.start();
        consThread6.start();

    }
}

class Producer implements Runnable {

    private final Vector sharedQueue;
    private final int SIZE;

    public Producer(Vector sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Produced: By Thread:"+Thread.currentThread().getName()+"::" + i);
            try {
                produce(i);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void produce(int i) throws InterruptedException {

        //wait if queue is full
        while (sharedQueue.size() == SIZE) {
            synchronized (sharedQueue) {
               /* System.out.println("Queue is full " + Thread.currentThread().getName() + "::"
                        + " is waiting , size: " + sharedQueue.size());*/

                sharedQueue.wait();
            }
        }

        //producing element and notify consumers
        synchronized (sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}

class Consumer implements Runnable {

    private final Vector sharedQueue;
    private final int SIZE;

    public Consumer(Vector sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: By Thread:"+Thread.currentThread().getName()+"::" + consume());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private int consume() throws InterruptedException {
        //wait if queue is empty
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                /*System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());*/

                sharedQueue.wait();
            }
        }

        //Otherwise consume element and notify waiting producer
        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return (Integer) sharedQueue.remove(0);
        }
    }
}





