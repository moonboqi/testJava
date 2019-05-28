/**
 * 
 */
package com.alex.designmode.state;

/**  
* Title: App  
* Description:   
* @author wangzi  
* @date 2019年1月23日  
*/
public class App {
	public static void main(String[] args) {
	    // 我们需要操作的是 iPhone X
	    Context context = new Context("iPhone X");

	    // 看看怎么进行补库存操作
	      State revertState = new RevertState();
	      revertState.doAction(context);

	    // 同样的，减库存操作也非常简单
	      State deductState = new DeductState();
	      deductState.doAction(context);

	      // 如果需要我们可以获取当前的状态
	     System.out.println("当前库存状态为："+context.getState().toString());
	     System.out.println("当前货品名称为："+context.getName());
	}
}
