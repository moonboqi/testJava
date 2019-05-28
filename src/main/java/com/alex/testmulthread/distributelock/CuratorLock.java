/**
 * 
 */
package com.alex.testmulthread.distributelock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import com.alex.testmulthread.lock.idgenerator.OrderNoLockServerImpl;
import com.alex.testmulthread.lock.idgenerator.OrderServerImpl;
import com.alex.testmulthread.lock.idgenerator.OrderServerInterface;
import com.alex.testmulthread.lock.task.OrderTask2;

/**
 * Title: CuratorLock Description:
 * 
 * @author wangzi
 * @date 2018年11月5日
 */
public class CuratorLock {

	final static CuratorFramework client = CuratorFrameworkFactory.builder()
			.connectString("11.113.0.16:2181,11.113.0.21:2181,11.113.0.27:2181")
			.retryPolicy(new ExponentialBackoffRetry(100, 1)).build();

	public static void main(String[] args) {
		client.start();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(1);
		OrderServerInterface orderServer = new OrderServerImpl();
		InterProcessMutex lock = new InterProcessMutex(client, "/bit");

		for (int i = 0; i < 10; i++) {
			executorService.submit(new OrderTask2(latch, new OrderNoLockServerImpl(), lock));
		}
		latch.countDown();
		executorService.shutdown();
	}
}
