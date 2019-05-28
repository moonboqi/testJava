/**
 * 
 */
package com.alex.designmode.template;

/**  
* Title: ConcreteTemplate  
* Description:模板模式只定义方法执行顺序，子类除了必须实现的抽象方法，可以任意实现其他方法   
* @author wangzi  
* @date 2019年1月23日  
*/
public class ConcreteTemplate extends AbstractTemplate {
	public void apply() {
		System.out.println("子类实现抽象方法 apply");
	}
	public void end() {
		System.out.println("我们可以把 method3 当做钩子方法来使用，需要的时候覆写就可以了");
	}
	
	
	public static void main(String[] args) {
		AbstractTemplate t = new ConcreteTemplate();
		// 调用模板方法
		t.templateMethod();
	}
}
