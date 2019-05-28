/**
 * 
 */
package com.alex.testrun;

/**  
* Title: TestPrintABC  
* Description:   
* @author wangzi  
* @date 2019年3月1日  
*/
public class TestPrintABC {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = null;
		for(int i=0; i<3; i++) {
			t1 = new Thread(new Task1());
			t1.start();
			t1.join();
		}
		
		
	}
}

class Task1 implements Runnable{
	Thread t2 = new Thread(new Task2());
	@Override
	public void run() {
		
		try {
			t2.start();
			t2.join();
			System.out.println("c");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
class Task2 implements Runnable{
	Thread t3 = new Thread(new Task3());
	@Override
	public void run() {
		try {
			t3.start();
			t3.join();
			System.out.println("b");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Task3 implements Runnable{

	@Override
	public void run() {
		System.out.println("a");
	}
}
