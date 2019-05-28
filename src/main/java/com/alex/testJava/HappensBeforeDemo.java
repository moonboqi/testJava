/**
 * 
 */
package com.alex.testJava;

/**  
* Title: HappensBeforeDemo  
* Description:   
* @author wangzi  
* @date 2019年2月18日  
*/
public class HappensBeforeDemo {
	private int a=1, b=2;

    public void foo(){  // 线程1 
        a=3;
        b=4;
    }

    public int getA(){ // 线程2
        return a;
    }    
    public int getB(){ // 线程2
        return b;
    }
    public static void main(String[] args) {
    	HappensBeforeDemo demo = new HappensBeforeDemo();
    	Thread t1 = new Thread(new Task1(demo));
    	Thread t2 = new Thread(new Task2(demo));
    	t2.start();
    	t1.start();
    	
	}
}

class Task1 implements Runnable{
	private HappensBeforeDemo demo;
	public Task1(HappensBeforeDemo demo) {
		super();
		this.demo = demo;
	}

	@Override
	public void run() {
		demo.foo();
	}
}

class Task2 implements Runnable{
	private HappensBeforeDemo demo;
	public Task2(HappensBeforeDemo demo) {
		super();
		this.demo = demo;
	}

	@Override
	public void run() {
		System.out.println(demo.getA());
		System.out.println(demo.getB());
	}
}
