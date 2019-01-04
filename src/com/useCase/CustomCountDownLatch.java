package com.useCase;

public class CustomCountDownLatch {

	private final Object LOCK;
	private volatile int   count;

	public CustomCountDownLatch(Object lOCK, int count) {
		LOCK = new Object();
		this.count = count;
	}

	protected void countDown() throws InterruptedException{
		synchronized(LOCK){
			count--;
			if(count==0) {
				LOCK.notifyAll();
			}
		}
	}

	protected void acquire() throws InterruptedException{

		synchronized(LOCK){
			while(count!=0){
				LOCK.wait();
			}
		}
	}

}
