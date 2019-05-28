/**
 * 
 */
package com.alex.designmode.singleton;

/**  
* Title: Singleton  
* Description:   
* @author wangzi  
* @date 2019年1月9日  
*/
public class Singleton {
	
	private static Singleton instance = new Singleton();
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		return instance;
		
	}
}
