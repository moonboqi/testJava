/**
 * 
 */
package com.alex.fivemonth.thread.demo29;

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
	        ThreadDomain29 td = new ThreadDomain29();
	        MyThread29[] mt = new MyThread29[5];
	        for (int i = 0; i < mt.length; i++)
	        {
	            mt[i] = new MyThread29(td);
	        }
	        for (int i = 0; i < mt.length; i++)
	        {
	            mt[i].start();
	        }
	        Thread.sleep(1000);
	        System.out.println(ThreadDomain29.aiRef.get());
	    } 
	    catch (InterruptedException e)
	    {
	        e.printStackTrace();
	    }
	}
}
