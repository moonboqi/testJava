/**
 * 
 */
package com.alex.testmulthread.countdownlatchtest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Title: CountdownlatchDemo Description:
 * 
 * @author wangzi
 * @date 2018年12月27日
 */
public class CountDownlatchDemo {
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(3);
		// 线程池
		ExecutorService threadPool = Executors.newCachedThreadPool();
		for (int i = 1; i <= 3; i++) {
			final int fI = i;
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					System.out.println("任务" + fI + "开始执行...");
					try {
						Thread.sleep((long) (Math.random()*1000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("任务" + fI + "执行完成!!!");
					latch.countDown();
				}
			};
			threadPool.execute(runnable);
		}
		// 计数器等待
		try {
			System.out.println("等待各个线程执行完成..");
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("各个线程执行完成，准备关闭线程池!!");
		// 线程池关闭
		threadPool.shutdown();
	}
}
