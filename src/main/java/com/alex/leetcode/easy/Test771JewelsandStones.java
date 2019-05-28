/**
 * 
 */
package com.alex.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * Title: Test771JewelsandStones Description:
 * 
 * @author wangzi
 * @date 2018年6月7日 You're given strings J representing the types of stones that
 *       are jewels, and S representing the stones you have. Each character in S
 *       is a type of stone you have. You want to know how many of the stones
 *       you have are also jewels.
 * 
 *       The letters in J are guaranteed distinct, and all characters in J and S
 *       are letters. Letters are case sensitive, so "a" is considered a
 *       different type of stone from "A".
 * 
 *       Example 1:
 * 
 *       Input: J = "aA", S = "aAAbbbb" Output: 3 Example 2:
 * 
 *       Input: J = "z", S = "ZZ" Output: 0 Note:
 * 
 *       S and J will consist of letters and have length at most 50. The
 *       characters in J are distinct.
 */
public class Test771JewelsandStones {
	@Test
	public void test1() throws Exception {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(numJewelsInStones("z", "ZZ"));
	}

	public int numJewelsInStones(String J, String S) {
		int num = 0;
		if (J != null && J.length() > 0 && S != null && S.length() > 0) {
			char[] jChars = J.toCharArray();
			char[] sChars = S.toCharArray();
			Arrays.sort(jChars);
			Arrays.sort(sChars);
			int j = 0;
			for (int i = 0; i < J.length(); i++) {
				char ch = jChars[i];
				for(; j< S.length(); j++) {
					if(ch == sChars[j]) {
						num++;
					}else if(ch < sChars[j]) {
						break;
					}
				}
				
			}
		}
		return num;
	}
}
