/**
 * 
 */
package com.alex.designmode.facade;

/**  
* Title: App  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class App {
	public static void main(String[] args) {
	    // 画一个圆形
	      Shape circle = new Circle();
	      circle.draw();

	      // 画一个长方形
	      Shape rectangle = new Rectangle();
	      rectangle.draw();
	}
}
