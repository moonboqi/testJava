/**
 * 
 */
package com.alex.designmode.simplefac;

/**  
* Title: Food  
* Description:   
* @author wangzi  
* @date 2019年1月8日  
*/
public class Food {
	private String description = "";
	protected void addSpicy (String str) {
		description += str+":";
	}
	protected void addCondiment(String str) {
		description += str+":";
	}
	protected void print() {
		System.out.println(description);
	}
}
