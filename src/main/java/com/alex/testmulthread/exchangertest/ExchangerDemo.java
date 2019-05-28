/**
 * 
 */
package com.alex.testmulthread.exchangertest;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Title: ExchangerDemo Description:
 * 
 * @author wangzi
 * @date 2018年12月25日
 */
public class ExchangerDemo {
	public static void main(String[] args) {
		// 交换器，交换string类型数据
		final Exchanger<String> ec = new Exchanger<>();
		// 线程池
		ExecutorService threadPool = Executors.newCachedThreadPool();
		//交换者1
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				try {
					String returnStr = ec.exchange("小乔");
					System.out.println("绑架者用小乔交换回：" + returnStr);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		//交换者2
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				try {
					String returnStr = ec.exchange("一千万");
					System.out.println("大乔用一千万交换回：" + returnStr);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		//交换者2
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				try {
					String returnStr = ec.exchange("空气");
					System.out.println("吃瓜群众用空气交换回：" + returnStr);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		threadPool.shutdown();
	}
}
