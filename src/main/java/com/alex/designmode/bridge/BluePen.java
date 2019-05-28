/**
 * 
 */
package com.alex.designmode.bridge;

/**  
* Title: BluePen  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class BluePen implements DrawAPI {
	   @Override
	   public void draw(int radius, int x, int y) {
	      System.out.println("用蓝色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
	   }
	}
