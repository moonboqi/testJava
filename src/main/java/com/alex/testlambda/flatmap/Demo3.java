/**
 * 
 */
package com.alex.testlambda.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**  
* Title: Demo3  
* Description:   
* @author alexw  
* @date 2020年4月2日  
*/
public class Demo3 {
	public static void main(String[] args) throws Exception {
        // 将集合中的字符串中单词提取出来，不考虑特殊字符
        List<String> words = Arrays.asList("hello c++", "hello java", "hello python");
        List<String> result = words.stream()
                // 将单词按照空格切合，返回Stream<String[]>类型的数据
                .map(word -> word.split(" "))
                // 将Stream<String[]>转换为Stream<String>
                .flatMap(Arrays::stream)
                // 去重
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
