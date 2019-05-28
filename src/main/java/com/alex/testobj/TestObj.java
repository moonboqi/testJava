/**
 * 
 */
package com.alex.testobj;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
* Title: TestObj  
* Description:   
* @author wangzi  
* @date 2018年7月2日  
*/
public class TestObj {
	public static void main(String[] args) {
		A a = new A();
		a.setName("张三");
		a.setNum(1);
		System.out.println(a);
		change(a);
		System.out.println(a);
	}
	
	public static void change(A a) {
		a.setName("李四");
		a.setNum(2);
	}
	
	@Test
	public void test1() throws Exception {
		A a = new A();
		a.setName("张三");
		a.setNum(2);
		A aa = a;
		System.out.println(aa.toString());
	}
	
	@Test
	public void testChangeValue() throws Exception {
		A a = new A();
		a.setName("张三");
		a.setNum(2);
		
		changeValue(a);
		System.out.println(a);
	}
	private void changeValue(A a) {
		String name = a.getName();
		name = "李四";
		a.setName(name);
	}
}
