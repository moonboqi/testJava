/**
 * 
 */
package com.alex.designmode.bridge;

/**  
* Title: App  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class App {
	public static void main(String[] args) {
	    Shape greenCircle = new Circle(10, new GreenPen());
	      Shape redRectangle = new Rectangle(4, 8, new RedPen());

	      greenCircle.draw();
	      redRectangle.draw();
	}
}
