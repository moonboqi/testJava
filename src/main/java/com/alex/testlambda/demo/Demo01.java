/**
 * 
 */
package com.alex.testlambda.demo;

/**  
* Title: Demo01  
* Description:   
* @author alexw  
* @date 2020年3月24日  
*/
public class Demo01 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            public void run(){
                System.out.println("多线程任务执行");
            }
        };
        new Thread(runnable).start();
    }
}
