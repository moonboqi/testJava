/**
 * 
 */
package com.alex.testmulthread.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Title: NoLockOrder Description:
 * 
 * @author wangzi
 * @date 2018年11月2日
 */
public class NoLockOrder {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final CountDownLatch latch = new CountDownLatch(1);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					try {
						latch.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("线程名称为：" + Thread.currentThread().getName() + ";订单号：%s" + getOrderNo());
				}
			});
		}
		latch.countDown();
		executorService.shutdown();
	}

	static int num = 0;

	public static synchronized String getOrderNo() {
		SimpleDateFormat date = new SimpleDateFormat("YYYYMMDDHHMMSS");
		return date.format(new Date()) + num++;
	}
}
