/**
 * 
 */
package com.alex.testmap;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Title: TestMap2 Description:
 * 
 * @author wangzi
 * @date 2018年10月29日
 */
public class TestMap2 {
	@Test
	public void testObj() throws Exception {
		// Student[] arr = new Student[5];
		// System.out.println(arr[3]);
		Student stu = new Student();
		System.out.println("原始hashcode值为：" + stu.hashCode());
		String binaryString = Integer.toBinaryString(stu.hashCode());
		System.out.println("二进制数表示为：" + binaryString);
		System.out.println("二进制位数为：" + binaryString.length());
		int h = 0;
		h ^= stu.hashCode();

		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		int result = h ^ (h >>> 7) ^ (h >>> 4);
		System.out.println("运算结果：" + result);
		System.out.println("二进制位数为：" + Integer.toBinaryString(result).length());
	}

	@Test
	public void testStatistic() throws Exception {
		int[] arr = new int[50];
		for (int i = 0; i < 10000; i++) {
			Student stu = new Student();
			int len = Integer.toBinaryString(stu.hashCode()).length();
			arr[len]++;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print("位数" + i + ":" + arr[i]+"\t");
			if(i%10==0) {
				System.out.println();
			}
		}
	}

}

class Student {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
