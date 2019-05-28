package com.alex.testrun;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRun {
	@Test
	public void test1() throws Exception {
		System.out.println("hello world");
		Person p = new Person();
		System.out.println(p);
		System.out.println(p==null);
	}
}

class Person {
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
