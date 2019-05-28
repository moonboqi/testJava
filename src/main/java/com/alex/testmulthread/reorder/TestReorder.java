/**
 * 
 */
package com.alex.testmulthread.reorder;

/**  
* Title: TestReorder  
* Description:   
* @author wangzi  
* @date 2019年1月25日  
*/
public class TestReorder {
	private int  a = 0;
	private long b = 0;
	void set() {
		a =  1;
		b = -1;
	}
	boolean check() {
		return ((b ==  0) ||(b == -1 && a == 1));
	}
	
	public static void main(String[] args) {
			TestReorder testReorder = new TestReorder();
			testReorder.set();
			System.out.println(testReorder.check());
	}
}
