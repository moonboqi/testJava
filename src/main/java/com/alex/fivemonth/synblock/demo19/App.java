/**
 * 
 */
package com.alex.fivemonth.synblock.demo19;

/**  
* Title: App  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class App {
	public static void main(String[] args)
	{
	    ThreadDomain19 td = new ThreadDomain19();
	    MyThread19_0 mt0 = new MyThread19_0(td);
	    MyThread19_1 mt1 = new MyThread19_1(td);
	    mt0.start();
	    mt1.start();
	}
}
