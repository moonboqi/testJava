/**
 * 
 */
package com.alex.fivemonth.thread.waitnotify;

import java.util.ArrayList;
import java.util.List;

/**  
* Title: aa  
* Description:   
* @author alexw  
* @date 2020年5月31日  
*/
public class MyThread30_0 extends Thread
{
    private Object lock;
    
    public MyThread30_0(Object lock)
    {
        this.lock = lock;
    }
    
    public void run()
    {
        try
        {
            synchronized (lock)
            {
                System.out.println("开始------wait time = " + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束------wait time = " + System.currentTimeMillis());
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
	}
}
