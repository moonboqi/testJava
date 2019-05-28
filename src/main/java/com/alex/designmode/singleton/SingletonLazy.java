/**
 * 
 */
package com.alex.designmode.singleton;

/**  
* Title: SingletonLazy  
* Description:   
* @author wangzi  
* @date 2019年1月9日  
*/
public class SingletonLazy {
	
	private static volatile SingletonLazy insatance;
	
	private SingletonLazy() {
		
	}
	
	public static SingletonLazy getInstance() {
		if(insatance != null) {
			synchronized(SingletonLazy.class) {
				if(insatance != null) {
					insatance = new SingletonLazy();
				}
			}
		}
		return insatance;
	}
}
