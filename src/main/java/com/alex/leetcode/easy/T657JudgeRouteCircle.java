/**
 * 
 */
package com.alex.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
* Title: T657JudgeRouteCircle  
* Description:   
* @author wangzi  
* @date 2018年8月6日  
* Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
*/
public class T657JudgeRouteCircle {
	@Test
	public void test1() throws Exception {
		String moves = "DURDLDRRLL";
		System.out.println(judgeCircle(moves));
	}
	
	public boolean judgeCircle(String moves) {
		if(moves==null || moves.length()==0) {
			return false;
		}
		int lr = 0;
		int ud = 0;
		for(int i=0; i<moves.length(); i++) {
			char ch = moves.charAt(i);
			if('L' == ch) {
				lr -= 1;
			}else if('R' == ch){
				lr += 1;
			}else if('D' == ch) {
				ud -= 1;
			}else if('U' == ch) {
				ud += 1;
			}
		}
		if(lr == 0 && ud == 0) {
			return true;
		}
        return false;
    }
}
