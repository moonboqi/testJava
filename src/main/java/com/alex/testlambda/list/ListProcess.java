/**
 * 
 */
package com.alex.testlambda.list;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Title: ListProcess Description:
 * 
 * @author alexw
 * @date 2020年4月20日
 */
public class ListProcess {
	public void test1() throws Exception {
		List<String> listStr = new ArrayList<>();
		listStr.add("aa");
		listStr.add("bb");
		listStr.add("cc");
		List<String> listNew = new ArrayList<>();
		listStr.stream().forEach(str -> {
			listNew.add(str);
			System.out.println(str);
		});
		listNew.stream().forEach(str2 -> System.out.println("新集合元素为：" + str2));
	}

	public void test2() throws Exception {
		List<String> listStr = Arrays.asList("aa", "bb", "cc");
		String str = "abc";
		Arrays.asList(str);
	}

	@Test
	public void test3() throws Exception {
		String[] dd = { "aa", "bb", "cc" };
		Stream<String> stream = Arrays.stream(dd);
		stream.filter(str -> str.contains("a")).forEach(System.out::println);// 返回字符串为a的值
	}

	@Test
	public void test4() throws Exception {
		String[] strs = { "aaa", "bbb", "ccc" };
		Arrays.stream(strs).map(str -> str.split("")).flatMap(str -> 
			Arrays.stream(str)).forEach(System.out::println);// aaabbbccc
		
	}
}
