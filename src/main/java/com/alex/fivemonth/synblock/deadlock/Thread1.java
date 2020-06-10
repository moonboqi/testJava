/**
 * 
 */
package com.alex.fivemonth.synblock.deadlock;

/**  
* Title: bb  
* Description:   
* @author alexw  
* @date 2020年5月28日  
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
