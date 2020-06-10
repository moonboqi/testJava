/**
 * 
 */
package com.alex.fivemonth.thread.demo28;

/**  
* Title: aa  
* Description:   
* @author alexw  
* @date 2020年5月28日  
*/
public class MyThread28 extends Thread
{
    private volatile boolean isRunning = true;

    public boolean isRunning()
    {
        return isRunning;
    }

    public void setRunning(boolean isRunning)
    {
        this.isRunning = isRunning;
    }
    
    public void run()
    {
        System.out.println("进入run了");
        while (isRunning == true){}
        System.out.println("线程被停止了");
    }
}
