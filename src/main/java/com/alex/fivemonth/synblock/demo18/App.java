/**
 * 
 */
package com.alex.fivemonth.synblock.demo18;

/**  
* Title: App  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class App {
	public static void main(String[] args)
	{
	    ThreadDomain18 td = new ThreadDomain18();
	    MyThread18 mt0 = new MyThread18(td);
	    MyThread18 mt1 = new MyThread18(td);
	    mt0.start();
	    mt1.start();
	}
}
