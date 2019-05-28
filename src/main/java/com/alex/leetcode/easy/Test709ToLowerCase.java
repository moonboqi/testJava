/**
 * 
 */
package com.alex.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
* Title: Test709ToLowerCase  
* Description:   
* @author wangzi  
* @date 2018年7月31日  
* Implement function ToLowerCase() that has a string parameter str, and returns the same string 
* in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"

*/
public class Test709ToLowerCase {
	
	@Test
	public void test1() throws Exception {
		String str = null;
		System.out.println(toLowerCase("LOVELY"));
	}
	
	public String toLowerCase(String str) {
		if(str!=null) {
			int len = str.length();
			if(len > 0) {
				char[] arr = new char[len];
				for(int i=0; i<len; i++) {
					char ch = str.charAt(i);
					if(ch >= 'A' && ch <= 'Z') {
						ch -= 'A' - 'a';
					}
					arr[i] = ch;
				}
				str = new String(arr);
			}
		}
        return str;
    }
}

