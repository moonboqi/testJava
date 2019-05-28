/**
 * 
 */
package com.alex.testmulthread.lock.task;

import java.util.concurrent.CountDownLatch;

import com.alex.testmulthread.lock.idgenerator.OrderServerInterface;

/**  
* Title: OrderTask  
* Description:   
* @author wangzi  
* @date 2018年11月5日  
*/
public class OrderTask implements Runnable {
	private CountDownLatch latch;
	private OrderServerInterface orderServer;
	
	public OrderTask(CountDownLatch latch, OrderServerInterface orderServer) {
		super();
		this.latch = latch;
		this.orderServer = orderServer;
	}

	@Override
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程名称为：" + Thread.currentThread().getName() + ";订单号：%s" + orderServer.getOrderNo());
	}

}
