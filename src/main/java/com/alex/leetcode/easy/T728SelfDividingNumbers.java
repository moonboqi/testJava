/**
 * 
 */
package com.alex.leetcode.easy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**  
* Title: T728SelfDividingNumbers  
* Description:   
* @author wangzi  
* @date 2018年8月7日  
* A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.
*/
public class T728SelfDividingNumbers {
	@Test
	public void test1() throws Exception {
		List<Integer> list = selfDividingNumbers(1, 22);
		for(int i: list) {
			System.out.println(i);
		}
	}
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<>();
		while(right>=left) {
			List<Integer> digits = getNumbers(left);
			boolean flag = true;
			for(int digit: digits) {
				if(digit==0 || left%digit != 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				list.add(left);
			}
			left++;
		}
        return list;
    }
	private List<Integer> getNumbers(int num){
		List<Integer> digits = new ArrayList<>();
		while(num > 0) {
			digits.add(num%10);
			num /= 10;
		}
		return digits;
	}
}
