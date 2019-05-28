/**
 * 
 */
package com.alex.testmulthread.semaphoretest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**  
* Title: SemaphoreDemo  
* Description:   
* @author wangzi  
* @date 2018年12月24日  
*/
public class SemaphoreDemo {
	private void execute() {
		//定义窗口数量
		final Semaphore semaphore = new Semaphore(2);
		//线程池
		ExecutorService threadPool = Executors.newCachedThreadPool();
		//模拟20个用户
		for(int i=0; i<20; i++) {
			//去买票
			threadPool.execute(new SemaphoreTask(semaphore, i+1));
		}
		threadPool.shutdown();
	}
	public static void main(String[] args) {
		SemaphoreDemo sd = new SemaphoreDemo();
		sd.execute();
	}
}
