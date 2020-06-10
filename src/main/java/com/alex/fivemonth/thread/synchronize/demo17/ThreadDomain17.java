/**
 * 
 */
package com.alex.fivemonth.thread.synchronize.demo17;

/**  
* Title: aa  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class ThreadDomain17
{
    public synchronized void testMethod()
    {
        try
        {
            System.out.println("Enter ThreadDomain17.testMethod, currentThread = " + 
                    Thread.currentThread().getName());
            long l = Integer.MAX_VALUE;
            l = 1000l;
            while (true)
            {
                long lo = 2 / l;
                Thread.sleep(1);
                l--;
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
