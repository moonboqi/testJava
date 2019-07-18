/**
 * 
 */
package com.alex.fivemonth.thread;

/**
 * Title: MyThread00 Description:
 * 
 * @author alexw
 * @date 2019年6月25日
 */
public class MyThread00 extends Thread {
	

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "在运行!");
		}
	}

	public static void main(String[] args) {
		MyThread00 mt0 = new MyThread00();
		mt0.start();

		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "在运行！");
		}
	}
}
