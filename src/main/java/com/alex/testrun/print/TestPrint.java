/**
 * 
 */
package com.alex.testrun.print;

/**  
* Title: TestPrint  
* Description:   
* @author wangzi  
* @date 2019年2月2日  
*/
public class TestPrint {
	public static void main(String[] args) {
		PrintProcess process = new PrintProcess();
		Thread t1 = new Thread(new Task1(process),"线程1");
		Thread t2 = new Thread(new Task2(process),"线程2");
		t1.start();
		t2.start();
	}
}

class PrintProcess{
	private int i=1;
    private Object obj = new Object();
    
    public void printOdd(){
    	synchronized (obj) {
    		while(i<=100) {
    			if(i%2==0) {
    				try {
        				obj.wait();
        			} catch (InterruptedException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
    			}
    			if(i<=100) {
    				System.out.println(Thread.currentThread().getName()+":"+i);
    			}
    			i++;
    			obj.notify();
    		}
		}
    }
    
    public void printEven(){
    	synchronized (obj) {
    		while(i<=100) {
    			if(i%2==1) {
    				try {
        				obj.wait();
        			} catch (InterruptedException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
    			}
    			if(i<=100) {
    				System.out.println(Thread.currentThread().getName()+":"+i);
    			}
    			i++;
    			obj.notify();
    		}
		}
    }
}

class Task1 implements Runnable{
	private PrintProcess process;
	public Task1(PrintProcess process) {
		super();
		this.process = process;
	}

	@Override
	public void run() {
		process.printOdd();
	}
}

class Task2 implements Runnable{
	private PrintProcess process;
	public Task2(PrintProcess process) {
		super();
		this.process = process;
	}

	@Override
	public void run() {
		process.printEven();
	}
}










