/**
 * 
 */
package com.alex.testmulthread.pooltest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.junit.Test;

/**
 * Title: TestOrdinaryPool Description:
 * 
 * @author wangzi
 * @date 2018年12月11日
 */
public class TestOrdinaryPool {
	@Test
	public void test1() throws Exception {
		Thread.currentThread().sleep(1000);
		System.out.println("打印------");
	}

	public static String getPrintTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(new Date());
	}

	@Test
	public void testPool() throws Exception {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5));
		// rejection-policy：当pool已经达到max size的时候，如何处理新任务
		// CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
		/*
		 * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
		 * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
		 * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
		 * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
		 */
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 定义计数器
		final CountDownLatch latch = new CountDownLatch(20);
		final ThreadPoolExecutor fPool = pool;
		for (int i = 0; i < 20; i++) {
			final int num = i;
			Runnable run = new Runnable() {
				public void run() {
					try {
						System.out.println("编号:{" + num + "}, 当前的核心池大小为：" + fPool.getCorePoolSize() + ",当前活动线程数为："
								+ fPool.getActiveCount() + ",当前排队总任务数量为：" + fPool.getTaskCount() + "，已完成的线程数为："
								+ fPool.getCompletedTaskCount() + "，执行时间：" + getPrintTime());

						// 如果所有的记录都拉取结束，则执行完成逻辑
						Thread.currentThread().sleep(1000);
						System.out.println("编号:{" + num + "},处理完成" + "，执行的线程名称为： " + Thread.currentThread().getName()
								+ "执行时间：" + getPrintTime());
					} catch (Exception e) {
						System.out.println("第{" + num + "}个任务信息拉取中发生异常");
					} finally {
						latch.countDown();
					}
					// 计数器减1
					// latch.countDown();
				}
			};
			try {
				pool.execute(run);
			} catch (Exception e) {
				System.out.println("第{" + num + "}个任务信息拉取完成处理发生异常" + "执行时间：" + getPrintTime());
				latch.countDown();
			}
		}
		// 计数器等待
		latch.await();

		// 线程池关闭
		pool.shutdown();
		System.out.println("所有的线程执行完毕！！！！！！！！！！！！！！！");
	}
}
