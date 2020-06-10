/**
 * 
 */
package com.alex.fivemonth.base;

/**  
* Title: TestInterrupt  
* Description:   
* @author alexw  
* @date 2019年9月11日  
*/
public class TestInterrupt {
	public static void main(String[] args)
	{
	    Thread.currentThread().interrupt();
	    System.out.println("是否停止1？" + Thread.interrupted());
	    System.out.println("是否停止2？" + Thread.interrupted());
	    System.out.println("end!");
	}
}
