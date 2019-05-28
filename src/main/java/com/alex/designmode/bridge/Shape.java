/**
 * 
 */
package com.alex.designmode.bridge;

/**  
* Title: Shape  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public abstract class Shape {
	   protected DrawAPI drawAPI;

	   protected Shape(DrawAPI drawAPI){
	      this.drawAPI = drawAPI;
	   }
	   public abstract void draw();    
	}
