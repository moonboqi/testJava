/**
 * 
 */
package com.alex.testlambda.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**  
* Title: Demo2  
* Description:   
* @author alexw  
* @date 2020年4月2日  
*/
public class Demo2 {
	public static void main(String[] args) throws Exception {
        // 求集合中每个元素的平方数
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = nums.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(result);
    }
}
