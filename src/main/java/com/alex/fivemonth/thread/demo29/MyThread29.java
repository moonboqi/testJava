/**
 * 
 */
package com.alex.fivemonth.thread.demo29;

/**  
* Title: bb  
* Description:   
* @author alexw  
* @date 2020年5月28日  
*/
public class MyThread29 extends Thread
{
    private ThreadDomain29 td;
    
    public MyThread29(ThreadDomain29 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        td.addNum();
    }
}
