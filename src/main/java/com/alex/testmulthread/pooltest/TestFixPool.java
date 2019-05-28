/**
 * 
 */
package com.alex.testmulthread.pooltest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Title: TestFixPool Description:
 * 
 * @author wangzi
 * @date 2018年8月15日
 */
public class TestFixPool {

	public static void main(String[] args) throws InterruptedException {
		// 定义计数器
		final CountDownLatch latch = new CountDownLatch(3);
		ExecutorService pool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			final int num = i;
			Runnable run = new Runnable() {
				public void run() {
					System.out.println("开始分线程拉取附件：·································");
					try {
						boolean isAllFinish = true;
						System.out.println("进件编号:{" + num + "}, 查询到的拉取记录表的结果：{}");
						// 如果所有的记录都拉取结束，则执行完成逻辑
					} catch (Exception e) {
						System.out.println("信息拉取完成处理发生异常");
					}
					// 计数器减1
					latch.countDown();
					System.out.println("计数器当前值为:" + latch.getCount());
				}
			};
			pool.execute(run);
		}
		// 计数器等待
		latch.await();
		System.out.println("线程执行完毕！！！！！！！！！！！！！！！");
		// 线程池关闭
		pool.shutdown();
	}

}
