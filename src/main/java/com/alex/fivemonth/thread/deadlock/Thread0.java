/**
 * 
 */
package com.alex.fivemonth.thread.deadlock;

/**  
* Title: Thread0  
* Description:   
* @author alexw  
* @date 2019年7月5日  
*/
public class Thread0 extends Thread
{
    private DeadLock dl;
    
    public Thread0(DeadLock dl)
    {
        this.dl = dl;
    }
    
    public void run()
    {
        try
        {
            dl.leftRight();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
