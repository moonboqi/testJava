/**
 * 
 */
package com.alex.fivemonth.thread.deadlock;

/**  
* Title: DeadLock  
* Description:   
* @author alexw  
* @date 2019年7月5日  
*/
public class DeadLock
{
    private final Object left = new Object();
    private final Object right = new Object();
    
    public void leftRight() throws Exception
    {
        synchronized (left)
        {
            Thread.sleep(2000);
            synchronized (right)
            {
                System.out.println("leftRight end!");
            }
        }
    }
    
    public void rightLeft() throws Exception
    {
        synchronized (right)
        {
            Thread.sleep(2000);
            synchronized (left)
            {
                System.out.println("rightLeft end!");
            }
        }
    }
}
