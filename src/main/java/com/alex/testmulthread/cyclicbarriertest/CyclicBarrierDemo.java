/**
 * 
 */
package com.alex.testmulthread.cyclicbarriertest;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Title: CyclicBarrierDemo Description:
 * 
 * @author wangzi
 * @date 2018年12月25日
 */
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		// 3个人聚餐
		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {

			@Override
			public void run() {
				System.out.println("人员到齐了，先合影留念！！！");
			}
		});
		// 线程池
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// 模拟三个用户
		for (int i = 0; i < 3; i++) {
			final int user = i + 1;
			Runnable r = new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println(user + "到达聚餐点，当前已有" + (cb.getNumberWaiting() + 1) + "人");
						cb.await();
						System.out.println("准备聚餐...");
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println(user + "聚餐结束，准备回家...");
						cb.await();
						System.out.println("回家咯");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			threadPool.execute(r);
		}
		threadPool.shutdown();
	}
}
