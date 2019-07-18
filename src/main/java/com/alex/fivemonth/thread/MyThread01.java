/**
 * 
 */
package com.alex.fivemonth.thread;

/**
 * Title: MyThread01 Description:
 * 
 * @author alexw
 * @date 2019年6月25日
 */
public class MyThread01 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "在运行!");
		}
	}

	public static void main(String[] args) {
		MyThread01 mt0 = new MyThread01();
		Thread t = new Thread(mt0);
		t.start();

		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "在运行！");
		}
	}
}
