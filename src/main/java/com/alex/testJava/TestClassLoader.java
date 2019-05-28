/**
 * 
 */
package com.alex.testJava;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Title: TestClassLoader Description:
 * 
 * @author wangzi
 * @date 2018年11月1日
 */
public class TestClassLoader {
	@Test
	public void testClassloader() throws Exception {
		ClassLoader loader = TestClassLoader.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader);
			loader = loader.getParent();
		}
		System.out.println(loader);
	}

	@Test
	public void testMyClassloader() throws Exception {
		Myclassloader cl = new Myclassloader("D:\\eclipse\\alex\\testJava\\target\\classes\\com\\alex\\testJava\\",
				"ZhangFei");
		Class<?> loadClass = cl.loadClass("com.alex.testJava.Demo");
		loadClass.newInstance();
	}
}
