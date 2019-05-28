/**
 * 
 */
package com.alex.designmode.facade;

/**  
* Title: App2  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class App2 {
	public static void main(String[] args) {
		  ShapeMaker shapeMaker = new ShapeMaker();

		  // 客户端调用现在更加清晰了
		  shapeMaker.drawCircle();
		  shapeMaker.drawRectangle();
		}
}
