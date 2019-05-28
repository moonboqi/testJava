/**
 * 
 */
package com.alex.designmode.bridge;

/**  
* Title: RedPen  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class RedPen implements DrawAPI {
	   @Override
	   public void draw(int radius, int x, int y) {
	      System.out.println("用红色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
	   }
	}
