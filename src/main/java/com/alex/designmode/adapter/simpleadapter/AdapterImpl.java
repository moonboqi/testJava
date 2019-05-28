/**
 * 
 */
package com.alex.designmode.adapter.simpleadapter;

/**  
* Title: FileMonitor  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class AdapterImpl extends SimpleAdapter {

	@Override
	public void play() {
		System.out.println("work,work");
	}

	@Override
	public void think() {
		System.out.println("play,play");
	}

	public static void main(String[] args) {
		SimpleInterface sim = new AdapterImpl();
		sim.play();
		sim.think();
	}
}
