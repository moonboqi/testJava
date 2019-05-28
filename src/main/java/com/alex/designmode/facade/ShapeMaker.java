/**
 * 
 */
package com.alex.designmode.facade;

/**  
* Title: ShapeMaker  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class ShapeMaker {
	   private Shape circle;
	   private Shape rectangle;

	   public ShapeMaker() {
	      circle = new Circle();
	      rectangle = new Rectangle();
	   }

	  /**
	   * 下面定义一堆方法，具体应该调用什么方法，由这个门面来决定
	   */

	   public void drawCircle(){
	      circle.draw();
	   }
	   public void drawRectangle(){
	      rectangle.draw();
	   }
	}
