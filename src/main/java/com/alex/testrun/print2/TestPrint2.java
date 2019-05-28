/**
 * 
 */
package com.alex.testrun.print2;

/**  
* Title: TestPrint2  
* Description:   
* @author wangzi  
* @date 2019年2月2日  
*/
public class TestPrint2 {
	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		Thread t1 = new Thread(new Task1(obj),"线程1");
		Thread t2 = new Thread(new Task2(obj),"线程2");
		t2.start();
		Thread.sleep(1000);
		t1.start();
		
	}
}

class Task1 implements Runnable{
	private Object obj;
	public Task1(Object obj) {
		super();
		this.obj = obj;
	}

	@Override
	public void run() {
		synchronized (obj) {
			for(int i=1; i<=100; i=i+2) {
				System.out.println(Thread.currentThread().getName()+":"+i);
				obj.notify();
				try {
    				obj.wait();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
			}
		}
	}
}

class Task2 implements Runnable{
	private Object obj;
	public Task2(Object obj) {
		super();
		this.obj = obj;
	}

	@Override
	public void run() {
		synchronized (obj) {
			for(int i=2; i<=100; i=i+2) {
				try {
    				obj.wait();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
				System.out.println(Thread.currentThread().getName()+":"+i);
				obj.notify();
			}
		}
	}
}

