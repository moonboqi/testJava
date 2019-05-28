/**
 * 
 */
package com.alex.testarray;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**  
* Title: TestArray  
* Description:   
* @author wangzi  
* @date 2018年7月19日  
*/
public class TestArray {
	@Test
	public void test1() throws Exception {
		String[] array = new String[] {" ","  bb"};
		System.out.println(array[0]+":"+array[1]);
//		for(String str: array) {
//			str = "cc";
//		}
//		for(int i=0; i<array.length; i++) {
//			array[i] = array[i].trim();
//		}
		trimArray(array);
		System.out.println(array[0]+":"+array[1]);
	}
	
	public void trimArray(String[] array) {
		for(int i=0; i<array.length; i++) {
			array[i] = array[i].trim();
		}
	}
	
	@Test
	public void test2() throws Exception {
		String str1 = ";abc;;def";
		String[] split = str1.split(";");
		for(String str: split) {
			System.out.println(str);
		}
		System.out.println("------------->"+split.length);
	}
	
	@Test
	public void testSortUtil() throws Exception {
		int[] arr = new int[] {1,4,2,3,5};
		Arrays.sort(arr);
	}
}
