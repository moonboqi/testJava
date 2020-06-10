/**
 * 
 */
package com.alex.fivemonth.synblock.demo20;

/**  
* Title: aa  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class App {
	public static void main(String[] args) throws Exception
    {
        ThreadDomain20 td = new ThreadDomain20();
        MyThread20_0 mt0 = new MyThread20_0(td);
        MyThread20_1 mt1 = new MyThread20_1(td);
        mt0.start();
        Thread.sleep(100);
        mt1.start();
    }
}
