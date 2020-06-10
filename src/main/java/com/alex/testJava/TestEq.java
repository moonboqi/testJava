/**
 * 
 */
package com.alex.testJava;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**  
* Title: TestEq  
* Description:   
* @author alexw  
* @date 2019年10月11日  
*/
public class TestEq {
	@Test
	public void testName() throws Exception {
		Integer i = null;
		System.out.println(1==i);
	}
	
	@Test
	public void test1() throws Exception {
		List<Boolean> list = new ArrayList<>();
		list.add(true);
		System.out.println(list.get(0));
		list.set(0, false);
		System.out.println(list.get(0));
	}
	
	@Test
	public void test2() throws Exception {
		boolean flag = true;
		System.out.println(flag?'1':'2');
	}
}
