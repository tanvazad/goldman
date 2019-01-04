package com.useCase.producerConsumerProblem.CustomBlockingQueue;

public class Consumer implements Runnable {

    private  CustomBlockingQueue<Integer> sharedQueue;

    public Consumer(CustomBlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while(true){
           // int item = consume();
            try {
                System.out.println("Consumed: By Thread:"+Thread.currentThread().getName()+"::" + consume());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }
    }

    private int consume() {
        int item;

        try {
            item = sharedQueue.deQueue();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            item= Integer.MIN_VALUE;
            System.out.println("Execption in consumer."+e);
            return item;
        }
        return item;
    }
}
