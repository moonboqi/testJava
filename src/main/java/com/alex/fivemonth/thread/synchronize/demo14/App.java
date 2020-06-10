/**
 * 
 */
package com.alex.fivemonth.thread.synchronize.demo14;

/**  
* Title: App  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class App {
	public static void main(String[] args)
	{
	    ThreadDomain14_0 td = new ThreadDomain14_0();
	    MyThread14_0 mt0 = new MyThread14_0(td);
	    mt0.setName("A");
	    MyThread14_1 mt1 = new MyThread14_1(td);
	    mt1.setName("B");
	    mt0.start();
	    mt1.start();
	}
}
