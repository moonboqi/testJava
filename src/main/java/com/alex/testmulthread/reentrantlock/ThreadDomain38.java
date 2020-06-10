/**
 * 
 */
package com.alex.testmulthread.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
* Title: ThreadDomain38  
* Description:   
* @author alexw  
* @date 2019年10月21日  
*/
public class ThreadDomain38
{
    private Lock lock = new ReentrantLock();
    
    public void testMethod()
    {
        try
        {
            lock.lock();
            for (int i = 0; i < 2; i++)
            {
                System.out.println("ThreadName = " + Thread.currentThread().getName() + 
                        ", i  = " + i);
            }
        }
        finally
        {
            lock.unlock();
        }
    }
}
