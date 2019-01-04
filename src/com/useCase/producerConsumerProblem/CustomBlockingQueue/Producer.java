package com.useCase.producerConsumerProblem.CustomBlockingQueue;

public class Producer implements Runnable {

    CustomBlockingQueue<Integer> sharedQueue;

    public Producer(CustomBlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while(true){
            produce();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce() {
        for(int i=1;i<3;i++){
            try {
                System.out.println("Produced: By Thread:"+Thread.currentThread().getName()+"::" + i);
                sharedQueue.enQueue(i);
            } catch (InterruptedException e) {
                System.out.println("Execption in Producer."+e);
            }
        }
    } 
}
