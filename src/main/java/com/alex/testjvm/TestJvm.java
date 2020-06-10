/**
 * 
 */
package com.alex.testjvm;

/**  
* Title: TestJvm  
* Description:   
* @author alexw  
* @date 2020年5月13日  
*/
public class TestJvm {
//	public static void main(String[] args){
//		while (true){
//			
//		}
//    }
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		System.out.println(System.getProperty("java.class.path"));
	}
}
