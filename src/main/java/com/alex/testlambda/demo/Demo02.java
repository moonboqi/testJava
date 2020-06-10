/**
 * 
 */
package com.alex.testlambda.demo;

/**  
* Title: Demo03  
* Description:   
* @author alexw  
* @date 2020年3月24日  
*/
public class Demo02 {
	public static void main(String[] args) {
        new Thread(()->{
            System.out.println("多线程启动");
        }).start();
    }
}
