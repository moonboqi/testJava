/**
 * 
 */
package com.alex.testarray;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**  
* Title: TestList  
* Description:   
* @author alexw  
* @date 2019年11月14日  
*/
public class TestList {
	@Test
	public void test1() throws Exception {
		List<String> list = new ArrayList<>(12);
		System.out.println(list.get(1));
		System.out.println(list.get(5));
		System.out.println(list.get(16));
	}
}
