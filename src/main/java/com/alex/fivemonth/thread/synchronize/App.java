/**
 * 
 */
package com.alex.fivemonth.thread.synchronize;

/**  
* Title: bb  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class App {
//	public static void main(String[] args)
//    {
//        ThreadDomain13 td = new ThreadDomain13();
//        MyThread13_0 mt0 = new MyThread13_0(td);
//        MyThread13_1 mt1 = new MyThread13_1(td);
//        mt0.start();
//        mt1.start();
//    }
	public static void main(String[] args) {
		ThreadDomain13 td0 = new ThreadDomain13();
	    ThreadDomain13 td1 = new ThreadDomain13();
	    MyThread13_0 mt0 = new MyThread13_0(td0);
	    MyThread13_1 mt1 = new MyThread13_1(td1);
	    mt0.start();
	    mt1.start();
	}
}
