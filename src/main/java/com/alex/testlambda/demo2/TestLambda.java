/**
 * 
 */
package com.alex.testlambda.demo2;

import java.io.File;

/**
 * Title: TestLambda Description:
 * 
 * @author alexw
 * @date 2020年3月26日
 */
public class TestLambda {
	public static void main(String[] args) {

		File[] files3 = new File("E:\\test").listFiles((File file) -> file.getName().equals("excel"));
		System.out.println(files3.length);

		// 单个参数的时候可以省略括号和类型，直接写形参
		File[] files4 = new File("F:\\test").listFiles((file -> file.getName().equals("abc.txt")));

		// 如果要写多行代码，可以加大括号把所有代码括起来，最后你同样需要返回正确的类型
		File[] files5 = new File("F:\\test").listFiles((File file) -> {
			boolean flag = file.getName().equals("d") && file.getName().contains("d");
			return flag;
		});
	}
}
