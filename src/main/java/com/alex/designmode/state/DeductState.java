/**
 * 
 */
package com.alex.designmode.state;

/**  
* Title: DeductState  
* Description:   
* @author wangzi  
* @date 2019年1月23日  
*/
public class DeductState implements State {

	   public void doAction(Context context) {
	      System.out.println("商品卖出，准备减库存");
	      context.setState(this);

	      //... 执行减库存的具体操作
	   }

	   public String toString(){
	      return "Deduct State";
	   }
	}
