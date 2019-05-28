/**
 * 
 */
package com.alex.testmulthread.interrupttest;

import java.util.concurrent.TimeUnit;

/**  
* Title: ThreadSafeStop  
* Description:   
* @author wangzi  
* @date 2019年1月21日  
*/
public class ThreadSafeStop {
	 
    public static void main(String[] args) throws Exception {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        // 睡眠 1 秒，通知 CountThread 中断，并终止线程
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
 
        Runner two = new Runner();
        countThread = new Thread(two,"CountThread2");
        countThread.start();
        // 睡眠 1 秒，然后设置线程停止状态，并终止线程
        TimeUnit.SECONDS.sleep(1);
        two.stopSafely();
    }
 
    private static class Runner implements Runnable {
 
        private long i;
 
        // 终止状态
        private volatile boolean on = true;
 
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                // 线程执行具体逻辑
                i++;
            }
            System.out.println("Count i = " + i);
        }
 
        public void stopSafely() {
            on = false;
        }
    }
}
