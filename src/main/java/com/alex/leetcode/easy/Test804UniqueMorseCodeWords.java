/**
 * 
 */
package com.alex.leetcode.easy;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Title: Test804UniqueMorseCodeWords Description:
 * 
 * @author wangzi
 * @date 2018年8月1日 International Morse Code defines a standard encoding where
 *       each letter is mapped to a series of dots and dashes, as follows: "a"
 *       maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * 
 *       For convenience, the full table for the 26 letters of the English
 *       alphabet is given below:
 * 
 *       [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.",
 *       "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."] Now,
 *       given a list of words, each word can be written as a concatenation of
 *       the Morse code of each letter. For example, "cab" can be written as
 *       "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-").
 *       We'll call such a concatenation, the transformation of a word.
 * 
 *       Return the number of different transformations among all words we have.
 * 
 *       Example: Input: words = ["gin", "zen", "gig", "msg"] Output: 2
 *       Explanation: The transformation of each word is: "gin" -> "--...-."
 *       "zen" -> "--...-." "gig" -> "--...--." "msg" -> "--...--."
 * 
 *       There are 2 different transformations, "--...-." and "--...--.".
 * 
 * 
 *       Note:
 * 
 *       The length of words will be at most 100. Each words[i] will have length
 *       in range [1, 12]. words[i] will only consist of lowercase letters.
 */
public class Test804UniqueMorseCodeWords {

	@Test
	public void test1() throws Exception {
		String[] words = new String[] {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));
	}

	public int uniqueMorseRepresentations(String[] words) {
		if (words == null || words.length == 0) {
			return 0;
		}
		if (words.length == 1) {
			return 1;
		}
		String[] morseCodes = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
				"-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
				"-.--", "--.." };
		Set<String> set = new HashSet<>();
		for(String word: words) {
			StringBuffer sb = new StringBuffer();
			for(char ch: word.toCharArray()) {
				sb.append(morseCodes[ch-'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
	}
}
