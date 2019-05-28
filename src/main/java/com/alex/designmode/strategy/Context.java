/**
 * 
 */
package com.alex.designmode.strategy;

/**  
* Title: Context  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class Context {
	   private Strategy strategy;

	   public Context(Strategy strategy){
	      this.strategy = strategy;
	   }

	   public void executeDraw(int radius, int x, int y){
	      strategy.draw(radius, x, y);
	   }
	   
	   public static void main(String[] args) {
		    Context context = new Context(new BluePen()); // 使用绿色笔来画
		      context.executeDraw(10, 0, 0);
		}
	}
