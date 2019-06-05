/**
 * 
 */
package com.alex.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, 
so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 */
/**
 * Title: T771JewelsandStones Description:
 * 
 * @author wangzi
 * @date 2019年5月29日
 */
public class T771JewelsandStones {
	@Test
	public void test1() throws Exception {
		System.out.println(numJewelsInStones2("z", "ZZ"));
	}
	public int numJewelsInStones(String J, String S) {
		int sum = 0;
		char[] arr = S.toCharArray();
		char[] ar = J.toCharArray();
		for(char ch: arr) {
			for(char c: ar) {
				if(ch == c) {
					sum++;
				}
			}
		}
        return sum;
    }
	public int numJewelsInStones2(String J, String S) {
        
        int numb=0;
        for(int q=0;q<S.length();q++){
            for(int w=0;w<J.length();w++){
                if(J.charAt(w)==S.charAt(q)){
                    numb++;
                }
            }
        }
        return numb;
    }
}
