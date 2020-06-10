/**
 * 
 */
package com.alex.fivemonth.thread.waitnotify;

import java.util.ArrayList;
import java.util.List;

/**  
* Title: bb  
* Description:   
* @author alexw  
* @date 2020年5月31日  
*/
public class MyThread30_1 extends Thread
{
    private Object lock;
    
    public MyThread30_1(Object lock)
    {
        this.lock = lock;
    }
    
    public void run()
    {
        synchronized (lock)
        {
            System.out.println("开始------notify time = " + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束------notify time = " + System.currentTimeMillis());
            try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    public static void main(String[] args) {
		List<A> list = new ArrayList<>();
		A aa1 = new A();
		aa1.setA(1);
		aa1.setB(2);
		A aa2 = new A();
		aa2.setA(3);
		aa2.setB(4);
//		list.add(aa);
//		list.get(0).setA(3);
//		System.out.println(aa);
		List<A> list1 = new ArrayList<>();
		list1.add(aa1);
		list1.add(aa2);
		list.addAll(list1);
		list1.get(0).setA(55);
		System.out.println(list.get(0));
	}
    
}

class A{
	int a;
	int b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + "]";
	}
	
}
