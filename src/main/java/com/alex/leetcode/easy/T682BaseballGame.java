/**
 * 
 */
package com.alex.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Title: T682BaseballGame Description:
 * 
 * @author wangzi
 * @date 2018年8月9日 Example 1: Input: ["5","2","C","D","+"] Output: 30
 *       Explanation: Round 1: You could get 5 points. The sum is: 5. Round 2:
 *       You could get 2 points. The sum is: 7. Operation 1: The round 2's data
 *       was invalid. The sum is: 5. Round 3: You could get 10 points (the round
 *       2's data has been removed). The sum is: 15. Round 4: You could get 5 +
 *       10 = 15 points. The sum is: 30. Example 2: Input:
 *       ["5","-2","4","C","D","9","+","+"] Output: 27 Explanation: Round 1: You
 *       could get 5 points. The sum is: 5. Round 2: You could get -2 points.
 *       The sum is: 3. Round 3: You could get 4 points. The sum is: 7.
 *       Operation 1: The round 3's data is invalid. The sum is: 3. Round 4: You
 *       could get -4 points (the round 3's data has been removed). The sum is:
 *       -1. Round 5: You could get 9 points. The sum is: 8. Round 6: You could
 *       get -4 + 9 = 5 points. The sum is 13. Round 7: You could get 9 + 5 = 14
 *       points. The sum is 27. Note: The size of the input list will be between
 *       1 and 1000. Every integer represented in the list will be between
 *       -30000 and 30000.
 */
public class T682BaseballGame {
	@Test
	public void test1() throws Exception {
//		String[] ops = new String[] {"5","2","C","D","+"};
		String[] ops = new String[] {"5","-2","4","C","D","9","+","+"};
		System.out.println(calPoints(ops));
	}

	public int calPoints(String[] ops) {
		int sum = 0;
		for (int i = 0; i < ops.length; i++) {
			int j = i;
			switch (ops[i]) {
			case "C":
				while(j>0) {
					if(!"C".equals(ops[j-1])) {
						sum -= Integer.valueOf(ops[j-1]);
						ops[j-1] = "C";
						break;
					}
					j--;
				}
				break;
			case "+":
				int current = 0;
				boolean flag = false;
				while (j>0) {
					if(!"C".equals(ops[j-1])) {
						if(flag) {
							current += Integer.valueOf(ops[j-1]);
							sum += current;
							ops[i] = String.valueOf(current);
							break;
						}else {
							current = Integer.valueOf(ops[j-1]);
							flag = true;
						}
					}
					j--;
				}
				break;
			case "D":
				while (j>0) {
					if(!"C".equals(ops[j-1])) {
						ops[i] = String.valueOf(2 * Integer.valueOf(ops[j-1]));
						sum += Integer.valueOf(ops[i]);
						break;
					}
					j--;
				}
				break;
			default:
				sum += Integer.valueOf(ops[i]);
				break;
			}
		}
		return sum;
	}
}
