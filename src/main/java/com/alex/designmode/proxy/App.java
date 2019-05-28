/**
 * 
 */
package com.alex.designmode.proxy;

/**  
* Title: App  
* Description:   
* @author wangzi  
* @date 2019年1月14日  
*/
public class App {
	public static void main(String[] args) {
		FoodService foodService = new FoodServiceProxy();
		foodService.makeChicken();
	}
}
