/**
 * 
 */
package com.alex.testmulthread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alex.testmulthread.lock.idgenerator.OrderServerImpl;
import com.alex.testmulthread.lock.idgenerator.OrderServerInterface;
import com.alex.testmulthread.lock.task.OrderTask;

/**  
* Title: JvmOrderLock  
* Description:   
* @author wangzi  
* @date 2018年11月5日  
*/
public class JvmOrderLock {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(1);
		OrderServerInterface orderServer = new OrderServerImpl();
		
		for (int i = 0; i < 10; i++) {
			executorService.execute(new OrderTask(latch, orderServer));
		}
		latch.countDown();
		executorService.shutdown();
	}
}
