/**
 * 
 */
package com.alex.testmulthread.interrupttest;

import java.util.concurrent.TimeUnit;

/**  
* Title: InterruptedException  
* Description:   
* @author wangzi  
* @date 2019年1月21日  
*/
public class InterruptedException implements Runnable {
	 
    @Override // 可以省略
    public void run() {
        // 一直 sleep
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) throws Exception {
 
        Thread interruptedThread = new Thread(new InterruptedException(), "InterruptedThread");
        interruptedThread.start();
 
        TimeUnit.SECONDS.sleep(2);
 
        // 中断被阻塞状态（sleep、wait、join 等状态）的线程，会抛出异常 InterruptedException
        // 在抛出异常 InterruptedException 前，JVM 会先将中断状态重置为默认状态 false
        interruptedThread.interrupt();
        System.out.println("InterruptedThread interrupted is " + interruptedThread.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }
}
