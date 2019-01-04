package com.useCase.producerConsumerProblem.CustomBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

    public class CustomBlockingQueue<E> {

    private Queue<E> queue;
    private int limit;

    public CustomBlockingQueue(int Limit){
        this.queue= new LinkedList<>();
        this.limit=Limit;
    }
    public synchronized void enQueue(E e) throws InterruptedException {
            while (queue.size() == limit) {
                System.out.println("Queue is full " + Thread.currentThread().getName() + "::"
                        + " is waiting , size: " + queue.size());
                wait(); 
            }
          //  System.out.println("Queue is not full" + Thread.currentThread().getName() + "is producing" + e);
            queue.add(e);
            notifyAll();
    }
    public synchronized E deQueue() throws InterruptedException {
            while (queue.size() == 0) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + queue.size());
                wait();
            }
            E e = queue.remove();
         //   System.out.println("Queue is not empty. " + Thread.currentThread().getName() + " is consuming " + e);
            notifyAll();
            return e;
    } 
}
