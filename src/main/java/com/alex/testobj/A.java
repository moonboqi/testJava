/**
 * 
 */
package com.alex.testobj;

/**  
* Title: A  
* Description:   
* @author wangzi  
* @date 2018年7月2日  
*/
public class A {
	private String name;
	private Integer num;

	@Override
	public String toString() {
		return "A [name=" + name + ", num=" + num + "]";
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
