/**
 * 
 */
package com.alex.designmode.adapter.classadapter;

/**  
* Title: SomeAdapter  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class SomeAdapter extends Something implements Target {

	@Override
	public void method3() {
		System.out.println("method3完成了");
	}

	public static void main(String[] args) {
		Target t = new SomeAdapter();
		t.method1();
		t.method2();
		t.method3();
	}
}
