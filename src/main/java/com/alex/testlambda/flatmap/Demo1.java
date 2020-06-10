/**
 * 
 */
package com.alex.testlambda.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**  
* Title: Demo1  
* Description:   
* @author alexw  
* @date 2020年4月2日  
*/
public class Demo1 {
	public static void main(String[] args) throws Exception {
        // 将集合中的所有的小写字母转为大写字母
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("python");
        List<String> result = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result);
    }
}
