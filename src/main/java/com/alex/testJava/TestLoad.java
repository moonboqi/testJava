/**
 * 
 */
package com.alex.testJava;

/**  
* Title: TestLoad  
* Description:   
* @author alexw  
* @date 2019年6月14日  
*/
public class TestLoad {
	public static void main(String[] args) {
//		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		System.out.println(System.getProperty("java.class.path"));
	}
}
