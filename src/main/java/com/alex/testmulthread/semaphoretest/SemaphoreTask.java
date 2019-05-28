/**
 * 
 */
package com.alex.testmulthread.semaphoretest;

import java.util.concurrent.Semaphore;

/**
 * Title: SemaphoreTask Description:
 * 
 * @author wangzi
 * @date 2018年12月24日
 */
public class SemaphoreTask implements Runnable {

	private Semaphore semaphore;
	private int user;

	public SemaphoreTask(Semaphore semaphore, int user) {
		this.semaphore = semaphore;
		this.user = user;
	}

	@Override
	public void run() {
		// 获取信号量许可
		try {
			semaphore.acquire();
			System.out.println("用户【" + user + "】进入窗口，准备买票...");
			Thread.sleep(3000);
			System.out.println("用户【" + user + "】买票完成，即将离开...");
			Thread.sleep(3000);
			System.out.println("用户【" + user + "】离开售票窗口...");
			semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
