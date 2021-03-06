/**
 * 
 */
package com.alex.testmulthread.interrupttest;

import java.util.concurrent.TimeUnit;

/**  
* Title: InterruptedThread  
* Description:   
* @author wangzi  
* @date 2019年1月21日  
*/
public class InterruptedThread implements Runnable {
	 
    @Override // 可以省略
    public void run() {
        // 一直 run
        while (true) {
        }
    }
 
    public static void main(String[] args) throws Exception {
 
        Thread interruptedThread = new Thread(new InterruptedThread(), "InterruptedThread");
        interruptedThread.start();
 
        TimeUnit.SECONDS.sleep(2);
 
        interruptedThread.interrupt();
        System.out.println("InterruptedThread interrupted is " + interruptedThread.isInterrupted());
 
        TimeUnit.SECONDS.sleep(2);
    }
}
