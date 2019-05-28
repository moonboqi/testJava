/**
 * 
 */
package com.alex.testbaseclass;

/**  
* Title: Base  
* Description:   
* @author wangzi  
* @date 2018年12月19日  
*/
public abstract class Base {
	public void doFirst() {
		System.out.println("doFirst");
	}
	public abstract void doSecond();
	public void doThird() {
		System.out.println("doThird");
	}
	public void doAll() {
		doFirst();
		doSecond();
		doThird();
	}
}
