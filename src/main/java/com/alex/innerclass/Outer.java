/**
 * 
 */
package com.alex.innerclass;

/**  
* Title: Outer  
* Description:   
* @author alexw  
* @date 2019年8月29日  
*/
public class Outer {
	static class Inner{
		
	}
	
	public static void main(String[] args) {
		Outer out = new Outer();
		System.out.println(new Inner().toString());
	}
}
