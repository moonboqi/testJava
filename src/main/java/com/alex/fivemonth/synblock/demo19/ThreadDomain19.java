/**
 * 
 */
package com.alex.fivemonth.synblock.demo19;

/**  
* Title: aa  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class ThreadDomain19
{
    public void serviceMethodA()
    {
        synchronized (this)
        {
            try
            {
                System.out.println("A begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end time = " + System.currentTimeMillis());
            } 
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            
        }
    }
    
    public void serviceMethodB()
    {
        synchronized (this)
        {
            System.out.println("B begin time = " + System.currentTimeMillis());
            System.out.println("B end time = " + System.currentTimeMillis());
        }
    }
}
