/**
 * 
 */
package com.alex.fivemonth.synblock.demo18;

/**  
* Title: abc  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class ThreadDomain18
{
    public void doLongTimeTask() throws Exception
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println("nosynchronized threadName = " + 
                    Thread.currentThread().getName() + ", i = " + (i + 1));
        }
        System.out.println();
        synchronized (this)
        {
            for (int i = 0; i < 100; i++)
            {
                System.out.println("synchronized threadName = " + 
                        Thread.currentThread().getName() + ", i = " + (i + 1));
            }
        }
    }
}
