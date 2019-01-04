package com.useCase.ThreadPool;


import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

public class ThreadPoolExecutorTest {
	public static void main(String[] args) throws Exception {
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
		// BlockingQueue queue1 = new LinkedBlockingQueue(5);


		RejectedExecutionHandler handler = new CallerRunsPolicy();

		//  RejectedExecutionHandler handler = new DiscardPolicy ();
		//RejectedExecutionHandler handler = new DiscardOldestPolicy();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 60,
				TimeUnit.SECONDS, queue, handler);
		for (int i = 1; i <= 20; i++) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("Thread Name >>" + Thread.currentThread().getName());
				}
			}
					);
		}
		pool.shutdown();
	}

}
