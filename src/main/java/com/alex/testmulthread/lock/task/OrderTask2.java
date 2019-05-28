/**
 * 
 */
package com.alex.testmulthread.lock.task;

import java.util.concurrent.CountDownLatch;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import com.alex.testmulthread.lock.idgenerator.OrderServerInterface;

/**
 * Title: OrderTask Description:
 * 
 * @author wangzi
 * @date 2018年11月5日
 */
public class OrderTask2 implements Runnable {
	private CountDownLatch latch;
	private OrderServerInterface orderServer;
	private InterProcessMutex lock;

	public OrderTask2(CountDownLatch latch, OrderServerInterface orderServer, InterProcessMutex lock) {
		super();
		this.latch = latch;
		this.orderServer = orderServer;
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			latch.await();
			lock.acquire();
			System.out.println("线程名称为：" + Thread.currentThread().getName() + ";订单号：%s" + orderServer.getOrderNo());
			lock.release();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
