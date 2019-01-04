package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class SequencePrinterUsingPriorityQueue {
	
	
	public static void main(String args[]){
		
		Worker1 w1 = new Worker1();
		Worker1 w2 = new Worker1();
		Worker1 w3 = new Worker1();
		
		w1.setNext(w2);
		w2.setNext(w3);
		w3.setNext(w1);
		
		Thread t1 = new Thread(w1,"Thread-1-");
		Thread t2 = new Thread(w2,"Thread-2-");
		Thread t3 = new Thread(w3,"Thread-3-");
		
		t1.start();
		t2.start();
		t3.start();
		
		w1.accept(1);
		
	} 
}

class Worker1 implements Runnable {
	
	BlockingQueue<Integer> q = new PriorityBlockingQueue<Integer>();
	Worker1 next = null;
	
	void setNext(Worker1 n){
		this.next = n;
	}
	
	void accept(int i){
		q.add(i);
	}

	@Override
	public void run() {		
		while(true){
			try{
			int r =q.take();
			System.out.println(Thread.currentThread().getName() + r);
			Thread.sleep(500);
			if(next!=null){
				next.accept(r+1);
			}
			}catch(Exception ex){}
		}		
	}
}