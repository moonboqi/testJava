/**
 * 
 */
package com.alex.fivemonth.thread.exceptionlock;

/**  
* Title: App  
* Description:   
* @author alexw  
* @date 2019年9月16日  
*/
public class App {
	public static void main(String[] args)
	{
	    ThreadDomain17 td = new ThreadDomain17();
	    MyThread17 mt0 = new MyThread17(td);
	    MyThread17 mt1 = new MyThread17(td);
	    mt0.start();
	    mt1.start();
	}
}
