/**
 * 
 */
package com.alex.fivemonth.thread.deadlock;

/**  
* Title: Thread1  
* Description:   
* @author alexw  
* @date 2019年7月5日  
*/
public class Thread1 extends Thread
{
    private DeadLock dl;
    
    public Thread1(DeadLock dl)
    {
        this.dl = dl;
    }
    
    public void run()
    {
        try
        {
            dl.rightLeft();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
