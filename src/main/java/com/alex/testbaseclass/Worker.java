/**
 * 
 */
package com.alex.testbaseclass;

/**  
* Title: Worker  
* Description:   
* @author wangzi  
* @date 2018年12月19日  
*/
public class Worker extends Base {
	@Override
	public void doSecond() {
		System.out.println("doSecond---worker");
	}
	
	public static void main(String[] args) {
//		Worker worker = new Worker();
		Base worker = new Worker();
		worker.doAll();
	}
}
