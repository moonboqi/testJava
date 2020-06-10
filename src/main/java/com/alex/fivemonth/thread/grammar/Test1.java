/**
 * 
 */
package com.alex.fivemonth.thread.grammar;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
* Title: Test1  
* Description:   
* @author alexw  
* @date 2019年8月7日  
*/
public class Test1 {
	//可变参数打印
	@Test
	public void test1() throws Exception {
		print("000", "111", "222", "333");
	}
	public void print(String...str) {
		for(int i=0; i<str.length; i++) {
			System.out.println(str[i]);
		}
	}
	
}
