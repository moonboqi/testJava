/**
 * 
 */
package com.alex.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
* Title: T868BinaryGap  
* Description:   
* @author wangzi  
* @date 2018年8月8日  
* Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.

If there aren't two consecutive 1's, return 0.

 

Example 1:

Input: 22
Output: 2
Explanation: 
22 in binary is 0b10110.
In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
The first consecutive pair of 1's have distance 2.
The second consecutive pair of 1's have distance 1.
The answer is the largest of these two distances, which is 2.
Example 2:

Input: 5
Output: 2
Explanation: 
5 in binary is 0b101.
Example 3:

Input: 6
Output: 1
Explanation: 
6 in binary is 0b110.
Example 4:

Input: 8
Output: 0
Explanation: 
8 in binary is 0b1000.
There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 

Note:

1 <= N <= 10^9
*/
public class T868BinaryGap {
	@Test
	public void test1() throws Exception {
		System.out.println(binaryGap(6));
	}
	public int binaryGap(int N) {
		String binStr = Integer.toBinaryString(N);
		char[] arr = binStr.toCharArray();
		char chFirst = '0';
		int distance = 0;
		int max = 0;
		for(char ch: arr) {
			if(chFirst == '1') {
				distance++;
				if(ch == '1') {
					max = Math.max(max, distance);
					distance = 0;
				}
			}
			if(ch == '1') {
				if(chFirst == '0') {
					chFirst = '1';
				}
			}
		}
        return max;
    }
}
