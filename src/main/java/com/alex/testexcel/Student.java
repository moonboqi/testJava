/**
 * 
 */
package com.alex.testexcel;

import lombok.Data;

/**  
* Title: Student  
* Description:   
* @author alexw  
* @date 2019年11月6日  
*/
@Data
public class Student {
    private int id;
    private String name;
    private String sex;
    
	/**
	 * @param id
	 * @param name
	 * @param sex
	 */
	public Student(int id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
}
