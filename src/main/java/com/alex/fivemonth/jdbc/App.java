/**
 * 
 */
package com.alex.fivemonth.jdbc;

import java.util.List;

/**  
* Title: App  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class App {
	public static void main(String[] args) throws Exception {
		List<Student> studentList = StudentManager.getInstance().querySomeStudents("Betty");
		for (Student student : studentList) {
		    System.out.println(student);
		}
	}
}
