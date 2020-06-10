/**
 * 
 */
package com.alex.fivemonth.thread.demo28;

/**  
* Title: App  
* Description:   
* @author alexw  
* @date 2020年5月28日  
*/
public class App {
	public static void main(String[] args)
	{
	    try
	    {
	        MyThread28 mt = new MyThread28();
	        mt.start();
	        Thread.sleep(1000);
	        mt.setRunning(false);
	        System.out.println("已赋值为false");
	    }
	    catch (InterruptedException e)
	    {
	        e.printStackTrace();
	    }
	}
}
